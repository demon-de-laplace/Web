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

public class DownloadTimesAction extends ActionSupport{
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
	@SuppressWarnings("unchecked")
	public CategoryDataset createDataSet(){
		DefaultCategoryDataset dataSet=new DefaultCategoryDataset();
		try{
			Session session=null;
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
		}catch(Exception e){
			e.printStackTrace();
		}
		dataSet.addValue(list.get(0).getDownloadTimes(),"","1st:"+list.get(0).getTitle());
		dataSet.addValue(list.get(1).getDownloadTimes(),"","2nd:"+list.get(1).getTitle());
		dataSet.addValue(list.get(2).getDownloadTimes(),"","3rd:"+list.get(2).getTitle());
		return dataSet;
	}
	public String execute()throws Exception{
		StandardChartTheme standardChartTheme=new StandardChartTheme("CN");
		standardChartTheme.setExtraLargeFont(new Font("隶书",Font.BOLD,20));
		standardChartTheme.setRegularFont(new Font("微软雅黑",Font.PLAIN,15));
		standardChartTheme.setLargeFont(new Font("微软雅黑",Font.PLAIN,15));
		ChartFactory.setChartTheme(standardChartTheme);
		chart=ChartFactory.createBarChart3D(
				"论文下载排行",
				"论文",
				"下载量",
				createDataSet(),
				PlotOrientation.VERTICAL,
				false,
				false,
				false);
		return SUCCESS;
	}
}
