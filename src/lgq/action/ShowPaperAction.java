package lgq.action;

import org.hibernate.Query;
import org.hibernate.Session;

import lgq.model.Paper;

import com.opensymphony.xwork2.ActionSupport;

public class ShowPaperAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private int articleId;
	private Paper paper;
	
	public Paper getPaper() {
		return paper;
	}
	public void setPaper(Paper paper) {
		this.paper = paper;
	}
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public String execute() throws Exception{
		Session session=null;
		try{
			session=HibernateSessionFactory.getSession();
			session.beginTransaction();
			String hql="from Paper p where p.articleId=\'"+articleId+"\'";
			Query query=session.createQuery(hql);
			paper=(Paper) query.list().get(0);
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
