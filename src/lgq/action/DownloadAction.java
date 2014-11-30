package lgq.action;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import lgq.model.Paper;

import org.apache.struts2.ServletActionContext;
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
		HttpServletResponse response = ServletActionContext.getResponse();
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
		byte[] b=new byte[is.available()];
		tempFile = new File(paper.getTitle()+".pdf");
		String title=paper.getTitle()+".pdf";
		OutputStream os=response.getOutputStream();
		response.setHeader("Content-disposition", "attachment;filename="+title);  
        //通知客服文件的MIME类型  
        response.setContentType("application/msword");  
        //通知客服文件的长度  
        long fileLength = tempFile.length();  
        String length = String.valueOf(fileLength);  
        response.setHeader("Content_length", length);
	    int size=0;  
        while((size=is.read(b))!=-1)
        {  
            os.write(b,0,size);
        }
        os.close();
        setInfo("文件下载成功。");
		return SUCCESS;
	}
}
