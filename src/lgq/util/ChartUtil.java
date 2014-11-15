package lgq.util;

import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class ChartUtil {
	public static CategoryDataset createDataSet(){
		DefaultCategoryDataset dataSet=new DefaultCategoryDataset();
		dataSet.addValue(550,"Java图书","Java SE 类");
		dataSet.addValue(100,"Java图书","Java ME 类");
		dataSet.addValue(960,"Java图书","Java EE 类");
		return dataSet;
	}
	public static JFreeChart createChart(){
		StandardChartTheme standardChartTheme=new StandardChartTheme("CN");
		standardChartTheme.setExtraLargeFont(new Font("隶书",Font.BOLD,20));
		standardChartTheme.setRegularFont(new Font("微软雅黑",Font.PLAIN,15));
		standardChartTheme.setLargeFont(new Font("微软雅黑",Font.PLAIN,15));
		ChartFactory.setChartTheme(standardChartTheme);
		JFreeChart chart=ChartFactory.createBarChart3D(
				"Java 图书销量统计",
				"Java 图书",
				"销量（本）",
				createDataSet(),
				PlotOrientation.VERTICAL,
				false,
				false,
				false);
		return chart;
	}
}
