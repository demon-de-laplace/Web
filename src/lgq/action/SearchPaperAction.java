package lgq.action;

import java.util.ArrayList;
import java.util.List;

import lgq.model.Paper;

import org.hibernate.Query;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SearchPaperAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private List<Paper> list;
	private List<Paper> list1;
	private List<Paper> list2;
	private String search1;
	private String search2;
	private String search3;
	private String search4;
	private String info;
	private double authorScore;
	
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getSearch1() {
		return search1;
	}
	public void setSearch1(String search1) {
		this.search1 = search1;
	}
	public String getSearch2() {
		return search2;
	}
	public void setSearch2(String search2) {
		this.search2 = search2;
	}
	public String getSearch3() {
		return search3;
	}
	public void setSearch3(String search3) {
		this.search3 = search3;
	}
	public String getSearch4() {
		return search4;
	}
	public void setSearch4(String search4) {
		this.search4 = search4;
	}
	public List<Paper> getList2() {
		return list2;
	}
	public void setList2(List<Paper> list2) {
		this.list2 = list2;
	}
	public List<Paper> getList1() {
		return list1;
	}
	public void setList1(List<Paper> list1) {
		this.list1 = list1;
	}
	public double getAuthorScore() {
		return authorScore;
	}
	public void setAuthorScore(double authorScore) {
		this.authorScore = authorScore;
	}
	public List<Paper> getList() {
		return list;
	}
	public void setList(List<Paper> list) {
		this.list = list;
	}
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception{
		authorScore=0;
		String s1="";
		String s2="";
		String s3="";
		String s4="";
		if(search1!="")
		{
			if(search2==""&&search3==""&&search4=="")
				s1="p.title like \'%"+search1+"%\'";
			else
				s1="p.title like \'%"+search1+"%\' and ";
		}
		if(search2!="")
		{
			if(search3==""&&search4=="")
				s2="p.author like \'%"+search2+"%\'";
			else
				s2="p.author like \'%"+search2+"%\' and ";
		}
		if(search3!="")
		{
			if(search4=="")
				s3="p.keyWord like \'%"+search3+"%\'";
			else
				s3="p.keyWord like \'%"+search3+"%\' and ";
		}
		if(search4!="")
			s4="p.year like \'%"+search4+"%\'";
		Session session=null;
		try{
			session=HibernateSessionFactory.getSession();
			session.beginTransaction();
			String hql="from Paper p where "+s1+s2+s3+s4;
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
		if(list.size()==0){
			info="抱歉，没有找到您想要的结果，";
			return ERROR;
		}
		if(search2!="")
		{
			for(int i=0;i<list.size();i++)
			{
				int rank=rankOfAuthor(list.get(i),search2);
				switch(rank)
				{
				case 1:authorScore=list.get(i).getScore();break;
				case 2:authorScore=list.get(i).getScore()*0.6;break;
				case 3:authorScore=list.get(i).getScore()*0.3;break;
				case 4:authorScore=list.get(i).getScore()*0.1;break;
				}
				list.get(i).setScore(authorScore);
			}
		}
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).getFlag()==0)
			{
				list.get(i).setScore(-1);
			}
		}
		list1=new ArrayList<Paper>();
		list2=new ArrayList<Paper>();
		for(int i=0;i<list.size();i++)
		{
			switch(list.get(i).getType1())
			{
			case "期刊论文":list1.add(list.get(i));break;
			case "会议论文":list2.add(list.get(i));break;
			}
		}
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).getFlag()==0)
				list.get(i).setType1("参考论文");
			else
				list.get(i).setType1("原创论文");
		}
		for(int i=0;i<list1.size();i++)
		{
			if(list1.get(i).getFlag()==0)
				list1.get(i).setType1("参考论文");
			else
				list1.get(i).setType1("原创论文");
		}
		for(int i=0;i<list2.size();i++)
		{
			if(list2.get(i).getFlag()==0)
				list2.get(i).setType1("参考论文");
			else
				list2.get(i).setType1("原创论文");
		}
		ActionContext.getContext().getSession().put("list1",list1);
		ActionContext.getContext().getSession().put("list2",list2);
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
