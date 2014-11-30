package lgq.action;

import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;

import lgq.model.Paper;

import com.opensymphony.xwork2.ActionSupport;

public class GoodLuckAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private List<Paper> list;
	private Paper paper;
	
	public Paper getPaper() {
		return paper;
	}
	public void setPaper(Paper paper) {
		this.paper = paper;
	}
	public List<Paper> getList() {
		return list;
	}
	public void setList(List<Paper> list) {
		this.list = list;
	}
	@SuppressWarnings("unchecked")
	public String execute()throws Exception{
		Session session=null;
		try{
			session=HibernateSessionFactory.getSession();
			session.beginTransaction();
			String hql="from Paper p";
			Query query=session.createQuery(hql);
			list=query.list();
			int num=list.size();
			Random ran=new Random(num);
			int random=ran.nextInt(num);
			paper=list.get(random);
			session.getTransaction().commit();
		}catch(Exception e)
		{
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateSessionFactory.closeSession();
		}
		return SUCCESS;
	}
}
