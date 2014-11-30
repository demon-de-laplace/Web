package lgq.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;

import lgq.model.DeleteLog;
import lgq.model.Paper;
import lgq.model.User;
import lgq.util.LogUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DeletePaperAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private int articleId;
	private Paper paper;
	private String info;
	private String infot;
	
	public String getInfot() {
		return infot;
	}
	public void setInfot(String infot) {
		this.infot = infot;
	}
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
		User user=(User)ActionContext.getContext().getSession().get("user");
		if(user==null)
		{
			infot="您还未登陆，请登陆后再进行操作。";
			return LOGIN;
		}
		Session session=null;
		try{
			session=HibernateSessionFactory.getSession();
			session.beginTransaction();
			paper=(Paper)session.load(Paper.class,articleId);
			DeleteLog deleteLog=new DeleteLog();
			LogUtil log=new LogUtil();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			deleteLog.setUsername(user.getUsername());
			deleteLog.setTitle(paper.getTitle());
			deleteLog.setAuthor(paper.getAuthor());
			deleteLog.setDate(df.format(new Date()));
			log.saveLog3(deleteLog);
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
