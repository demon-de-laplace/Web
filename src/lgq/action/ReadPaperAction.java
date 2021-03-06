package lgq.action;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import lgq.model.Paper;

import org.hibernate.Query;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;

public class ReadPaperAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private int articleId;
	private Paper paper;
	private File tempFile;
	private String info1;
	private String info2;
	private String info3;
	
	public String getInfo3() {
		return info3;
	}
	public void setInfo3(String info3) {
		this.info3 = info3;
	}
	public String getInfo1() {
		return info1;
	}
	public void setInfo1(String info1) {
		this.info1 = info1;
	}
	public String getInfo2() {
		return info2;
	}
	public void setInfo2(String info2) {
		this.info2 = info2;
	}
	public File getTempFile() {
		return tempFile;
	}
	public void setTempFile(File tempFile) {
		this.tempFile = tempFile;
	}
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
		String path=this.getClass().getClassLoader().getResource("/").getPath();
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
		InputStream is=new ByteArrayInputStream(paper.getContent());
		byte[] b=new byte[is.available()];
		tempFile = new File(path+"..\\..\\temp.pdf");
		FileOutputStream output = new FileOutputStream(tempFile);
	    int size=0;  
        while((size=is.read(b))!=-1)
        {  
            output.write(b,0,size);
        }
        is.close();
        output.close();
        switch(paper.getEffect())
        {
        case "level1":info3="领域顶级期刊论文或影响因子处在最高20%的期刊";break;
        case "level2":info3="SCI影响因子(IF)>1.0";break;
        case "level3":info3="0.1≤SCI影响因子(IF)<1.0";break;
        case "level4":info3="SCI影响因子(IF)<0.1";break;
        case "level5":info3="无";break;
        }
        info1=paper.getOtherInfo().substring(0,paper.getOtherInfo().indexOf(","));
		info2=paper.getOtherInfo().substring(paper.getOtherInfo().indexOf(",")+1);
		return SUCCESS;
	}
}
