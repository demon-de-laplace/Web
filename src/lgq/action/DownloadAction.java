package lgq.action;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import lgq.model.Paper;

import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;

public class DownloadAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private int articleId;
	private Paper paper;
	private File tempFile;
	private String info;
	
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
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
		try{
			session=HibernateSessionFactory.getSession();
			session.beginTransaction();
			paper=(Paper)session.load(Paper.class,new Integer(articleId));
			int num=paper.getDownloadTimes()+1;
			paper.setDownloadTimes(num);
			session.getTransaction().commit();
		}catch(Exception e)
		{
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateSessionFactory.closeSession();
		}
		InputStream is=new ByteArrayInputStream(paper.getContent());
		System.out.println(paper.getContent().toString());
		byte[] b=new byte[is.available()];
		tempFile = new File("D:\\"+paper.getTitle()+".pdf");
		FileOutputStream output = new FileOutputStream(tempFile);
	    int size=0;  
        while((size=is.read(b))!=-1)
        {  
            System.out.println(size);
            output.write(b,0,size);
        }
        output.close();
        setInfo("文件已成功下载到目录D:\\下。");
		return SUCCESS;
	}
}
