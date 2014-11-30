package lgq.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import lgq.model.DeleteLog;
import lgq.model.UpdateLog;
import lgq.model.UploadLog;
import lgq.util.LogUtil;

public class SearchLog extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private List<UploadLog> list1;
	private List<UpdateLog> list2;
	private List<DeleteLog> list3;
	private String info;
	
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public List<UploadLog> getList1() {
		return list1;
	}
	public void setList1(List<UploadLog> list1) {
		this.list1 = list1;
	}
	public List<UpdateLog> getList2() {
		return list2;
	}
	public void setList2(List<UpdateLog> list2) {
		this.list2 = list2;
	}
	public List<DeleteLog> getList3() {
		return list3;
	}
	public void setList3(List<DeleteLog> list3) {
		this.list3 = list3;
	}
	public String uploadLog() throws Exception
	{
		LogUtil util=new LogUtil();
		String sql="select * from ninja.dbo.uploadLog";
		list1=util.search1(sql);
		if(list1.size()==0)
		{
			info="抱歉，没有找到任何操作信息，";
			return "error";
		}
		return "upload";
	}
	public String updateLog() throws Exception
	{
		LogUtil util=new LogUtil();
		String sql="select * from ninja.dbo.updateLog";
		list2=util.search2(sql);
		if(list2.size()==0)
		{
			info="抱歉，没有找到任何操作信息，";
			return "error";
		}
		return "update";
	}
	public String deleteLog() throws Exception
	{
		LogUtil util=new LogUtil();
		String sql="select * from ninja.dbo.deleteLog";
		list3=util.search3(sql);
		if(list3.size()==0)
		{
			info="抱歉，没有找到任何操作信息，";
			return "error";
		}
		return "delete";
	}
}
