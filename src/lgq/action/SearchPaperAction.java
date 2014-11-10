package lgq.action;

import java.util.List;

import lgq.model.Paper;

import org.hibernate.Query;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;

public class SearchPaperAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private List<Paper> list;
	private String typet;
	private String search;
	private double authorScore;
	
	public double getAuthorScore() {
		return authorScore;
	}
	public void setAuthorScore(double authorScore) {
		this.authorScore = authorScore;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getTypet() {
		return typet;
	}
	public void setTypet(String typet) {
		this.typet = typet;
	}
	public List<Paper> getList() {
		return list;
	}
	public void setList(List<Paper> list) {
		this.list = list;
	}
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception{
		String type="";
		authorScore=0;
		switch(typet)
		{
			case "题目":type="title";break;
			case "作者":type="author";break;
			case "关键字":type="keyWord";break;
			case "发表时间":type="year";break;
		}
		Session session=null;
		try{
			session=HibernateSessionFactory.getSession();
			session.beginTransaction();
			String hql="from Paper p where p."+type+" like \'%"+search+"%\'";
			Query query=session.createQuery(hql);
			list=query.list();
			session.getTransaction().commit();
		}catch(Exception e)
		{
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateSessionFactory.closeSession();
		}
		switch(typet)
		{
			case "题目":break;
			case "作者":
				{
					for(int i=0;i<list.size();i++)
					{
						int rank=rankOfAuthor(list.get(i),search);
						switch(rank)
						{
						case 1:authorScore=list.get(i).getScore();break;
						case 2:authorScore=list.get(i).getScore()*0.6;break;
						case 3:authorScore=list.get(i).getScore()*0.3;break;
						case 4:authorScore=list.get(i).getScore()*0.1;break;
						}
						list.get(i).setScore(authorScore);
					}
					break;
				}
			case "关键字":break;
			case "发表时间":break;
		}
		return SUCCESS;
	}
	private int rankOfAuthor(Paper paper,String authorTemp)
	{
		String s=paper.getAuthor();
		int a=s.indexOf(authorTemp);
		int b=s.indexOf(",");
		if(a==0)
			return 1;
		else{
			if(b+1==a)
				return 2;
			else{
				int c=s.indexOf(",",b+1);
				if(c+1==a)
					return 3;
				else{
					int d=s.indexOf(",",c+1);
					if(d+1==a)
						return 4;
					return 4;
				}
			}
		}
	}
}
