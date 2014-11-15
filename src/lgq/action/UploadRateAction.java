package lgq.action;

import java.awt.Font;
import java.text.NumberFormat;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import lgq.model.Paper;

import com.opensymphony.xwork2.ActionSupport;

public class UploadRateAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private JFreeChart chart;
	private List<Paper> list;
	
	public List<Paper> getList() {
		return list;
	}
	public void setList(List<Paper> list) {
		this.list = list;
	}
	public JFreeChart getChart() {
		return chart;
	}
	public void setChart(JFreeChart chart) {
		this.chart = chart;
	}
	@SuppressWarnings("unchecked")
	public PieDataset initPieData(){
		DefaultPieDataset dataset=new DefaultPieDataset();
		try{
			Session session=null;
			try{
				session=HibernateSessionFactory.getSession();
				session.beginTransaction();
				String hql="from Paper p";
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
			
		}catch(Exception e){
			e.printStackTrace();
		}
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
		if(num1!=0)
			dataset.setValue("SCI索引论文",num1);
		if(num2!=0)
			dataset.setValue("EI索引论文",num2);
		if(num3!=0)
			dataset.setValue("非SCI/EI索引国外期刊",num3);
		if(num4!=0)
			dataset.setValue("非SCI/EI索引国内一级期刊",num4);
		if(num5!=0)
			dataset.setValue("非SCI/EI索引国内核心期刊",num5);
		if(num6!=0)
			dataset.setValue("非SCI/EI索引国内一般期刊",num6);
		if(num7!=0)
			dataset.setValue("国际CCF A类会议",num7);
		if(num8!=0)
			dataset.setValue("国际CCF B类会议",num8);
		if(num9!=0)
			dataset.setValue("国际CCF C类会议",num9);
		if(num10!=0)
			dataset.setValue("国际其它类会议",num10);
		if(num11!=0)
			dataset.setValue("国内会议",num11);
		return dataset;
	}
	public String execute()
    {
		chart=ChartFactory.createPieChart3D("论文类型统计",initPieData(),true,true,false);
		chart.getTitle().setFont(new Font("隶书",Font.BOLD,20));
		chart.getLegend().setItemFont(new Font("宋体",Font.BOLD,15));
		PiePlot plot=(PiePlot)chart.getPlot();
		plot.setForegroundAlpha(0.5f);
		plot.setLabelFont(new Font("宋体",Font.PLAIN,12));
		plot.setCircular(true);
		plot.setLabelGenerator(new StandardPieSectionLabelGenerator
				("{0}={2}",
				NumberFormat.getNumberInstance(),
				NumberFormat.getPercentInstance()
						)
				);
            return SUCCESS;
    }
}
