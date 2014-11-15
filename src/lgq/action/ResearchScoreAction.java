package lgq.action;

import java.awt.Font;
import java.util.List;

import lgq.model.Paper;

import org.hibernate.Query;
import org.hibernate.Session;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import com.opensymphony.xwork2.ActionSupport;

public class ResearchScoreAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private JFreeChart chart;
	private List<Paper> list;
	public JFreeChart getChart() {
		return chart;
	}
	public void setChart(JFreeChart chart) {
		this.chart = chart;
	}
	public List<Paper> getList() {
		return list;
	}
	public void setList(List<Paper> list) {
		this.list = list;
	}
	@SuppressWarnings({ "unchecked" })
	public CategoryDataset createDataSet(){
		DefaultCategoryDataset dataSet=new DefaultCategoryDataset();
		try{
			Session session=null;
			try{
				session=HibernateSessionFactory.getSession();
				session.beginTransaction();
				String hql="from Paper p where p.flag=1";
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
		int score1=0;
		int score2=0;
		int score3=0;
		int score4=0;
		int score5=0;
		int score6=0;
		for(int i=0;i<list.size();i++)
		{
			int score=(int)list.get(i).getScore();
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
		dataSet.setValue(score1,"","<20");
		dataSet.setValue(score2,"","20-40");
		dataSet.setValue(score3,"","40-60");
		dataSet.setValue(score4,"","60-80");
		dataSet.setValue(score5,"","80-100");
		dataSet.setValue(score6,"","100<");
		return dataSet;
	}
	public String execute()throws Exception{
		StandardChartTheme standardChartTheme=new StandardChartTheme("CN");
		standardChartTheme.setExtraLargeFont(new Font("隶书",Font.BOLD,20));
		standardChartTheme.setRegularFont(new Font("微软雅黑",Font.PLAIN,10));
		standardChartTheme.setLargeFont(new Font("微软雅黑",Font.PLAIN,15));
		ChartFactory.setChartTheme(standardChartTheme);
		chart=ChartFactory.createBarChart3D(
				"论文科研考核分数分布",
				"科研考核分数",
				"数量",
				createDataSet(),
				PlotOrientation.VERTICAL,
				false,
				false,
				false);
		return SUCCESS;
	}
}
