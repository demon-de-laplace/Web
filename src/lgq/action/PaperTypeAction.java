package lgq.action;

import java.awt.Font;
import java.text.NumberFormat;
import java.util.List;

import lgq.model.Paper;

import org.hibernate.Query;
import org.hibernate.Session;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import com.opensymphony.xwork2.ActionSupport;

public class PaperTypeAction extends ActionSupport{
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
		int num=0;
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).getFlag()==0)
				num++;
		}
		dataset.setValue("参考论文",num);
		dataset.setValue("原创论文",list.size()-num);
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
