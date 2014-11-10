package lgq.util;

import java.awt.Font;
import java.text.NumberFormat;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.PieDataset;
import org.jfree.data.jdbc.JDBCPieDataset;

public class ChartUtil {
	public static PieDataset initPieData(){
		String driveName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url="jdbc:sqlserver://localhost:1433;DatabaseName=ninja";
		String user="sa";
		String password="31415926think";
		JDBCPieDataset dataset=null;
		try{
			dataset=new JDBCPieDataset(url,driveName,user,password);
			String sql="select title,downloadTimes from paper";
			dataset.executeQuery(sql);
			dataset.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return dataset;
	}
	public static JFreeChart creatChart(){
		JFreeChart chart=ChartFactory.createPieChart3D("论文下载统计",initPieData(),true,true,false);
		chart.getTitle().setFont(new Font("隶书",Font.BOLD,25));
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
		return chart;
	}
}
