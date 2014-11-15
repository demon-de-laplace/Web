<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Register</title>
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
  <center>
  	<div style="margin-top:20;margin-left:20;font-size:20;height:50">
  		输入用户注册信息
  	</div>
  	<FONT color="red"><s:actionerror /></FONT>
  	<s:form action="registerA">
  		<s:textfield label="用户名" name="user.username" required="true"></s:textfield>
  		<s:password label="密码" name="user。password" required="true"></s:password>
  		<s:password label="确认密码" name="user.repassword" required="true"></s:password>
  		<s:textfield label="电子邮件" name="user.email" required="true"></s:textfield>
  		<s:submit value="注册"></s:submit>
  	</s:form>
  </center>
  </body>
</html>
