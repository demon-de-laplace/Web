package lgq.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lgq.model.Paper;

import org.hibernate.Query;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;

public class StatisticsAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private String info1;
	private String info2;
	private String info3;
	private String info4;
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
	public String getInfo3() {
		return info3;
	}
	public void setInfo3(String info3) {
		this.info3 = info3;
	}
	public String getInfo4() {
		return info4;
	}
	public void setInfo4(String info4) {
		this.info4 = info4;
	}
	@SuppressWarnings("unchecked")
	public String execute() throws Exception
	{
		Session session=null;
		List<Paper> list=new ArrayList<Paper>();
		try{
			session=HibernateSessionFactory.getSession();
			session.beginTransaction();
			String hql="from Paper p order by downloadTimes desc";
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
		int original=0;
		int reference=0;
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).getFlag()==0)
				reference++;
			else
				original++;
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		int total=original+reference;
		info1="PaperPro是一个论文管理系统，系统内的论文可以包括两部分：原创论文与参考论文，其中原创论文可以参与科研分数考核。到现在为止（"+df.format(new Date()).toString()+"）"
				+ "共有"+total+"篇论文，其中，可以参与科研分数考核的原创论文"+original+"篇，参考论文"+reference+"篇";
		info2="PaperPro中的论文都可以下载，不需要登录。到现在为止（"+df.format(new Date()).toString()+"），下载量最大的是《"+list.get(0).getTitle()+
				"》，作者："+list.get(0).getAuthor()+".下载"+list.get(0).getDownloadTimes()+"次。";
		int score1=0;
		int score2=0;
		int score3=0;
		int score4=0;
		int score5=0;
		int score6=0;
		for(int i=0;i<list.size();i++)
		{
			int score=(int)list.get(i).getScore();
			if(list.get(i).getFlag()==1)
			{
				switch(score/20)
				{
				case 0:score1++;break;
				case 1:score2++;break;
				case 2:score3++;break;
				case 3:score4++;break;
				case 4:score5++;break;
				case 5:score6++;break;
				}
			}
		}
		info3="PaperPro对原创论文进行科研分数考核。在所有的原创论文中，分数低于20分的有"+score1+"篇；"+"分数高于20分低于40分的有"+score2+"篇;"+
		"分数高于40分低于60分的有"+score3+"篇；"+"分数高于60分低于80分的有"+score4+"篇；"+"分数高于80分低于100分的有"+score5+"篇；"+"分数高于100分的有"+score6+"篇";
		int num1=0;
		int num2=0;
		int num3=0;
		int num4=0;
		int num5=0;
		int num6=0;
		int num7=0;
		int num8=0;
		int num9=0;
		int num10=0;
		int num11=0;
		for(int i=0;i<list.size();i++)
		{
			switch(list.get(i).getType2())
			{
			case "SCI索引论文":num1++;break;
			case "EI索引论文":num2++;break;
			case "非SCI/EI索引国外期刊":num3++;break;
			case "非SCI/EI索引国内一级期刊":num4++;break;
			case "非SCI/EI索引国内核心期刊":num5++;break;
			case "非SCI/EI索引国内一般期刊":num6++;break;
			case "国际CCF A类会议":num7++;break;
			case "国际CCF B类会议":num8++;break;
			case "国际CCF C类会议":num9++;break;
			case "国际其它类会议":num10++;break;
			case "国内会议":num11++;break;
			}
		}
		String s1="";
		String s2="";
		String s3="";
		String s4="";
		String s5="";
		String s6="";
		String s7="";
		String s8="";
		String s9="";
		String s10="";
		String s11="";
		if(num1!=0)
			s1="SCI索引论文有"+num1+"篇。";
		if(num2!=0)
			s2="EI索引论文"+num2+"篇。";
		if(num3!=0)
			s3="非SCI/EI索引国外期刊"+num3+"篇。";
		if(num4!=0)
			s4="非SCI/EI索引国内一级期刊"+num4+"篇。";
		if(num5!=0)
			s5="非SCI/EI索引国内核心期刊"+num5+"篇。";
		if(num6!=0)
			s6="非SCI/EI索引国内一般期刊"+num6+"篇。";
		if(num7!=0)
			s7="国际CCF A类会议"+num7+"篇。";
		if(num8!=0)
			s8="国际CCF B类会议"+num8+"篇。";
		if(num9!=0)
			s9="国际CCF C类会议"+num9+"篇。";
		if(num10!=0)
			s10="国际其它类会议"+num10+"篇。";
		if(num11!=0)
			s11="国内会议"+num11+"篇。";
		info4="PaperPro论文类型共有11种。其中："+s1+s2+s3+s4+s5+s6+s7+s8+s9+s10+s11;
		return SUCCESS;
	}
}
