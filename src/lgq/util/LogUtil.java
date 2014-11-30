package lgq.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lgq.model.DeleteLog;
import lgq.model.UpdateLog;
import lgq.model.UploadLog;

public class LogUtil {
	private final String sqlcon="jdbc:sqlserver://localhost:1433;DatabaseName=ninja";
	private final String username="sa";
	private final String password="31415926think";
	
	public Connection getConnection() throws Exception
	{
		Connection con=null;
		if(con==null)
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con=DriverManager.getConnection(sqlcon,username,password);
		}
		return con;
	}
	public PreparedStatement getStatement(String sql) throws Exception
	{
		Connection con;
		PreparedStatement ps;
		con=getConnection();
		ps=con.prepareStatement(sql);
		return ps;
	}
	public void saveLog1(UploadLog uploadLog) throws Exception
	{
		Connection con;
		con=getConnection();
		PreparedStatement ps;
		String sql="Insert into ninja.dbo.uploadLog(username,title,author,date)values(?,?,?,?)";
		ps=getStatement(sql);
		ps.setString(1,uploadLog.getUsername());
		ps.setString(2,uploadLog.getTitle());
		ps.setString(3,uploadLog.getAuthor());
		ps.setString(4,uploadLog.getDate());
		ps.executeUpdate();
		ps.close();
		con.close();
	}
	public void saveLog2(UpdateLog updateLog) throws Exception
	{
		Connection con;
		con=getConnection();
		PreparedStatement ps;
		String sql="Insert into ninja.dbo.updateLog(username,title,author,date)values(?,?,?,?)";
		ps=getStatement(sql);
		ps.setString(1,updateLog.getUsername());
		ps.setString(2,updateLog.getTitle());
		ps.setString(3,updateLog.getAuthor());
		ps.setString(4,updateLog.getDate());
		ps.executeUpdate();
		ps.close();
		con.close();
	}
	public void saveLog3(DeleteLog deleteLog) throws Exception
	{
		Connection con;
		con=getConnection();
		PreparedStatement ps;
		String sql="Insert into ninja.dbo.deleteLog(username,title,author,date)values(?,?,?,?)";
		ps=getStatement(sql);
		ps.setString(1,deleteLog.getUsername());
		ps.setString(2,deleteLog.getTitle());
		ps.setString(3,deleteLog.getAuthor());
		ps.setString(4,deleteLog.getDate());
		ps.executeUpdate();
		ps.close();
		con.close();
	}
	public List<UploadLog> search1(String sql) throws Exception
	{
		Connection con;
		con=getConnection();
		Statement stm=con.createStatement();
		ResultSet rs;
		rs=stm.executeQuery(sql);
		List<UploadLog> list=new ArrayList<UploadLog>();
		while(rs.next())
		{
			UploadLog log=new UploadLog();
			log.setUsername(rs.getString("username"));
			log.setTitle(rs.getString("title"));
			log.setAuthor(rs.getString("author"));
			log.setDate(rs.getString("date"));
			list.add(log);
		}
		rs.close();
		stm.close();
		con.close();
		return list;
	}
	public List<UpdateLog> search2(String sql) throws Exception
	{
		Connection con;
		con=getConnection();
		Statement stm=con.createStatement();
		ResultSet rs;
		rs=stm.executeQuery(sql);
		List<UpdateLog> list=new ArrayList<UpdateLog>();
		while(rs.next())
		{
			UpdateLog log=new UpdateLog();
			log.setUsername(rs.getString("username"));
			log.setTitle(rs.getString("title"));
			log.setAuthor(rs.getString("author"));
			log.setDate(rs.getString("date"));
			list.add(log);
		}
		rs.close();
		stm.close();
		con.close();
		return list;
	}
	public List<DeleteLog> search3(String sql) throws Exception
	{
		Connection con;
		con=getConnection();
		Statement stm=con.createStatement();
		ResultSet rs;
		rs=stm.executeQuery(sql);
		List<DeleteLog> list=new ArrayList<DeleteLog>();
		while(rs.next())
		{
			DeleteLog log=new DeleteLog();
			log.setUsername(rs.getString("username"));
			log.setTitle(rs.getString("title"));
			log.setAuthor(rs.getString("author"));
			log.setDate(rs.getString("date"));
			list.add(log);
		}
		rs.close();
		stm.close();
		con.close();
		return list;
	}
}
