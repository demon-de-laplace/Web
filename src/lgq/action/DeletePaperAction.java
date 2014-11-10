package lgq.action;

import org.hibernate.Session;

import lgq.model.Paper;

import com.opensymphony.xwork2.ActionSupport;

public class DeletePaperAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private int articleId;
	private Paper paper;
	private String info;
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public Paper getPaper() {
		return paper;
	}
	public void setPaper(Paper paper) {
		this.paper = paper;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String execute()throws Exception
	{
		Session session=null;
		try{
			session=HibernateSessionFactory.getSession();
			session.beginTransaction();
			paper=(Paper)session.load(Paper.class,articleId);
			session.delete(paper);
			setInfo("一篇论文删除成功，");
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
