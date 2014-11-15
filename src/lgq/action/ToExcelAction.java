package lgq.action;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import lgq.model.Paper;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("deprecation")
public class ToExcelAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private String filename;
	private String path;
	String info;
	
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@SuppressWarnings({ "unchecked", "resource" })
	public String execute ()throws Exception{
		List<Paper> list1=(List<Paper>) ActionContext.getContext().getSession().get("list1");
		List<Paper> list2=(List<Paper>) ActionContext.getContext().getSession().get("list2");
		HSSFWorkbook book=new HSSFWorkbook();
		HSSFSheet sheet=book.createSheet();
		HSSFCellStyle titleStyle=book.createCellStyle();
		titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER_SELECTION);
		titleStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		HSSFFont titleFont=book.createFont();
		titleFont.setFontHeightInPoints((short)15);
		titleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		titleFont.setFontName("黑体");
		titleStyle.setFont(titleFont);
		int col=list1.size();
		sheet.addMergedRegion(new CellRangeAddress(0,1,0,13));
		sheet.addMergedRegion(new CellRangeAddress(3+col,4+col,0,13));
		HSSFRow row=null;
		HSSFCell cell=null;
		row=sheet.createRow(0);
		cell=row.createCell(0);
		cell.setCellStyle(titleStyle);
		cell.setCellValue(new HSSFRichTextString("期刊论文查询结果"));
		row=sheet.createRow(3+col);
		cell=row.createCell(0);
		cell.setCellStyle(titleStyle);
		cell.setCellValue(new HSSFRichTextString("会议论文查询结果"));
		HSSFCellStyle tableStyle=book.createCellStyle();
		tableStyle.setBorderBottom((short)1);
		tableStyle.setBorderTop((short)1);
		tableStyle.setBorderLeft((short)1);
		tableStyle.setBorderRight((short)1);
		tableStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		HSSFFont tableFont=book.createFont();
		tableFont.setFontHeightInPoints((short)12);
		tableFont.setFontName("宋体");
		tableStyle.setFont(tableFont);
		String []title1={"序号","题目","作者","类别","期刊名称","发表年份","发表月份","期卷","始末页","SCI收录号","EI收录号","ISTP收录号","科研分数","下载次数"};
		String []title2={"序号","题目","作者","类别","会议名称","发表年份","发表月份","届别","举办地点","SCI收录号","EI收录号","ISTP收录号","科研分数","下载次数"};
		row=sheet.createRow(2);
		for(int i=0;i<title1.length;i++)
		{
			cell=row.createCell(i);
			cell.setCellStyle(tableStyle);
			cell.setCellValue(new HSSFRichTextString(title1[i]));
		}
		row=sheet.createRow(5+col);
		for(int i=0;i<title2.length;i++)
		{
			cell=row.createCell(i);
			cell.setCellStyle(tableStyle);
			cell.setCellValue(new HSSFRichTextString(title2[i]));
		}
		for(int i=0;i<list1.size();i++)
		{
			row=sheet.createRow(i+3);
			cell=row.createCell(0);
			cell.setCellStyle(tableStyle);
			cell.setCellValue(i+1);
			

			cell=row.createCell(1);
			cell.setCellStyle(tableStyle);
			cell.setCellValue(new HSSFRichTextString(list1.get(i).getTitle()));
			
			cell=row.createCell(2);
			cell.setCellStyle(tableStyle);
			cell.setCellValue(new HSSFRichTextString(list1.get(i).getAuthor()));
			

			cell=row.createCell(3);
			cell.setCellStyle(tableStyle);
			cell.setCellValue(new HSSFRichTextString(list1.get(i).getType1()));
			

			cell=row.createCell(4);
			cell.setCellStyle(tableStyle);
			cell.setCellValue(new HSSFRichTextString(list1.get(i).getName()));
			

			cell=row.createCell(5);
			cell.setCellStyle(tableStyle);
			cell.setCellValue(list1.get(i).getYear());			

			cell=row.createCell(6);
			cell.setCellStyle(tableStyle);
			cell.setCellValue(list1.get(i).getMonth());
			
			String info1=list1.get(i).getOtherInfo().substring(0,list1.get(i).getOtherInfo().indexOf(","));
			String info2=list1.get(i).getOtherInfo().substring(list1.get(i).getOtherInfo().indexOf(",")+1);
			cell=row.createCell(7);
			cell.setCellStyle(tableStyle);
			cell.setCellValue(new HSSFRichTextString(info1));
			cell=row.createCell(8);
			cell.setCellStyle(tableStyle);
			cell.setCellValue(new HSSFRichTextString(info2));
			
			cell=row.createCell(9);
			cell.setCellStyle(tableStyle);
			cell.setCellValue(new HSSFRichTextString(list1.get(i).getSci()));
			
			cell=row.createCell(10);
			cell.setCellStyle(tableStyle);
			cell.setCellValue(new HSSFRichTextString(list1.get(i).getEi()));
			
			cell=row.createCell(11);
			cell.setCellStyle(tableStyle);
			cell.setCellValue(new HSSFRichTextString(list1.get(i).getIstp()));
			
			double total=0;
			for(int j=0;j<list1.size();j++)
			{
				if(list1.get(i).getScore()>=0)
					total+=list1.get(j).getScore();
			}
			String s;
			if(list1.get(i).getScore()>=0)
				s=list1.get(i).getScore()+"/"+total;
			else
				s="—";
			cell=row.createCell(12);
			cell.setCellStyle(tableStyle);
			cell.setCellValue(new HSSFRichTextString(s));
			
			cell=row.createCell(13);
			cell.setCellStyle(tableStyle);
			cell.setCellValue(list1.get(i).getDownloadTimes());
		}
		for(int i=0;i<list2.size();i++)
		{
			row=sheet.createRow(i+6+col);
			cell=row.createCell(0);
			cell.setCellStyle(tableStyle);
			cell.setCellValue(i+1);
			

			cell=row.createCell(1);
			cell.setCellStyle(tableStyle);
			cell.setCellValue(new HSSFRichTextString(list2.get(i).getTitle()));
			
			cell=row.createCell(2);
			cell.setCellStyle(tableStyle);
			cell.setCellValue(new HSSFRichTextString(list2.get(i).getAuthor()));
			

			cell=row.createCell(3);
			cell.setCellStyle(tableStyle);
			cell.setCellValue(new HSSFRichTextString(list2.get(i).getType1()));
			

			cell=row.createCell(4);
			cell.setCellStyle(tableStyle);
			cell.setCellValue(new HSSFRichTextString(list2.get(i).getName()));
			

			cell=row.createCell(5);
			cell.setCellStyle(tableStyle);
			cell.setCellValue(list2.get(i).getYear());			

			cell=row.createCell(6);
			cell.setCellStyle(tableStyle);
			cell.setCellValue(list2.get(i).getMonth());
			
			String info1=list2.get(i).getOtherInfo().substring(0,list2.get(i).getOtherInfo().indexOf(","));
			String info2=list2.get(i).getOtherInfo().substring(list2.get(i).getOtherInfo().indexOf(",")+1);
			cell=row.createCell(7);
			cell.setCellStyle(tableStyle);
			cell.setCellValue(new HSSFRichTextString(info1));
			cell=row.createCell(8);
			cell.setCellStyle(tableStyle);
			cell.setCellValue(new HSSFRichTextString(info2));
			
			cell=row.createCell(9);
			cell.setCellStyle(tableStyle);
			cell.setCellValue(new HSSFRichTextString(list2.get(i).getSci()));
			
			cell=row.createCell(10);
			cell.setCellStyle(tableStyle);
			cell.setCellValue(new HSSFRichTextString(list2.get(i).getEi()));
			
			cell=row.createCell(11);
			cell.setCellStyle(tableStyle);
			cell.setCellValue(new HSSFRichTextString(list2.get(i).getIstp()));
			
			double total=0;
			for(int j=0;j<list2.size();j++)
			{
				if(list2.get(i).getScore()>=0)
					total+=list2.get(j).getScore();
			}
			String s;
			if(list2.get(i).getScore()>=0)
				s=list2.get(i).getScore()+"/"+total;
			else
				s="—";
			cell=row.createCell(12);
			cell.setCellStyle(tableStyle);
			cell.setCellValue(new HSSFRichTextString(s));
			
			cell=row.createCell(13);
			cell.setCellStyle(tableStyle);
			cell.setCellValue(list2.get(i).getDownloadTimes());
		}
		File xlsFile=new File(path,filename);
		FileOutputStream fos=new FileOutputStream(xlsFile);
		book.write(fos);
		fos.close();
		setInfo("导出成功，");
		return SUCCESS;
	}
}
