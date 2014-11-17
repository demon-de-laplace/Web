<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
<script type="text/javascript" src="js/myjs.js"></script>
  </head>
  <body>
    This is my JSP page. <br>
    <center>
     <form id="UserAction" name="UserAction" action="/register/UserAction!save.action" method="post" >
		
		<table class="wwFormTable">
        <tbody><tr>
    	<td class="tdLabel"><label for="username" class="label">用户名:</label></td>
    	<td><input type="text" name="user.username" value="" id="username" class="bian" onblur="checkUsername()"><br> 
    		<span id="usernameMsg"></span><br></td>
</tr>
          	
          	   <tr>
    	<td class="tdLabel"><label for="password" class="label">密码:</label></td>
    	<td><input type="password" name="user.password" id="password" class="bian" onblur="checkPassword()"><br> 
   			 <span id="passwordMsg"></span><br></td>
</tr>

          		     
          	   <tr>
    	<td class="tdLabel"><label for="repassword" class="label">确认密码:</label></td>
    	<td><input type="password" name="repassword" id="repassword" class="bian" onblur="checkRepassword()"><br>
    		<span id="repasswordMsg"></span><br></td>
</tr>
          	           
          	   <tr>
    	<td class="tdLabel"><label for="email" class="label">邮箱地址:</label></td>
    	<td><input type="text" name="user.email" value="" id="email" class="bian" onblur="checkEmail()"><br>
    		<span id="emailMsg"></span><br></td>
</tr>
          	           
          	   <tr>
    <td colspan="2"><div align="right"><input type="submit" id="UserAction_0" value="注册" onclick="return register()">
</div></td>
</tr>

     </tbody></table></form></center>
  </body>
</html>
