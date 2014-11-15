<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>To Excel</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body><br><br>
  <div style="width:300;height:180;margin-left: auto;margin-right: auto;">
	<s:form action="toExcelA" method="post">
		<s:textfield name="filename" label="文件名"></s:textfield>
		<s:textfield name="path" label="保存路径"></s:textfield>
		<s:submit value="导出"></s:submit>
	</s:form>
	</div>
	<center><a href="javascript:history.back(-1)">返回</a></center>
  </body>
</html>
