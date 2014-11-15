<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.jfree.chart.servlet.ServletUtilities,lgq.util.ChartUtil" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Data Statistics</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	 <iframe id="frm1" name="frm1"  src="paperTypeA" style="width:50%;position:absolute;height:50%;border:1;left:10;top:10"></iframe>
  	 <iframe id="frm2" name="frm2"  src="downloadTimesA" style="width:50%;position:absolute;height:50%;border:1;left:10;bottom:10"></iframe>
  	 <iframe id="frm3" name="frm3"  src="researchScoreA" style="width:50%;position:absolute;height:50%;border:1;right:30;top:10"></iframe>
  	 <iframe id="frm4" name="frm4"  src="uploadRateA" style="width:50%;position:absolute;height:50%;border:1;right:30;bottom:10"></iframe>
  </body>
</html>
