<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Login.jsp' starting page</title>
    
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
    <%@taglib prefix="s" uri="/struts-tags" %>
    <s:form action="UserAction!login" method="post">
    <s:fielderror></s:fielderror>
             	<s:textfield name="user.username" label="用户名" cssClass="bian"></s:textfield>
          		    <s:password name="user.password" label="密码" cssClass="bian"></s:password>
          	         <s:submit value="确定" ></s:submit>
     </s:form></center>
  </body>
</html>
