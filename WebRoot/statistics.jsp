<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="lgq.model.User" %>
<%@page import="com.opensymphony.xwork2.ActionContext;" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
			User user=(User)ActionContext.getContext().getSession().get("user");
			String username="";
			int flag1=0;
			if(user!=null)
			{
				username=user.getUsername();
				flag1=1;
			}
		 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Statistics</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Statistics</title>
<style type="text/css">
html {
	overflow-Y: scroll;
}
body {
	font: 16px normal Arial, Helvetica, sans-serif;
	margin: 0;
	padding: 0;
	line-height: 1.7em;
}
*, * focus {
	outline: none;
	margin: 0;
	padding: 0;
}

.container {
	width: 500px;
	margin: 0 auto;
}
h1 {
	font: 4em normal Georgia, 'Times New Roman', Times, serif;
	text-align:center;
	padding: 20px 0;
	color: #aaa;
}
h1 span { color: #666; }
h1 small{
	font: 0.3em normal Verdana, Arial, Helvetica, sans-serif;
	text-transform:uppercase;
	letter-spacing: 0.5em;
	display: block;
	color: #666;
}

h2.acc_trigger {
	padding: 0;	margin: 0 0 5px 0;
	background: url(images/h2_trigger_a.gif) no-repeat;
	height: 46px;	line-height: 46px;
	width: 500px;
	font-size: 2em;
	font-weight: normal;
	float: left;
}
h2.acc_trigger a {
	color: #fff;
	text-decoration: none;
	display: block;
	padding: 0 0 0 50px;
}
h2.acc_trigger a:hover {
	color: #ccc;
}
h2.active {background-position: left bottom;}
.acc_container {
	margin: 0 0 5px; padding: 0;
	overflow: hidden;
	font-size: 1.2em;
	width: 500px;
	clear: both;
	background: #f0f0f0;
	border: 1px solid #d6d6d6;
	-webkit-border-bottom-right-radius: 5px;
	-webkit-border-bottom-left-radius: 5px;
	-moz-border-radius-bottomright: 5px;
	-moz-border-radius-bottomleft: 5px;
	border-bottom-right-radius: 5px;
	border-bottom-left-radius: 5px; 
}
.acc_container .block {
	padding: 20px;
}
.acc_container .block p {
	padding: 5px 0;
	margin: 5px 0;
}
.acc_container h3 {
	font: 2.5em normal Georgia, "Times New Roman", Times, serif;
	margin: 0 0 10px;
	padding: 0 0 5px 0;
	border-bottom: 1px dashed #ccc;
}
.acc_container img {
	float: left;
	margin: 10px 15px 15px 0;
	padding: 5px;
	background: #ddd;
	border: 1px solid #ccc;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
//Set default open/close settings
$('.acc_container').hide(); //Hide/close all containers
$('.acc_trigger:first').addClass('active').next().show(); //Add "active" class to first trigger, then show/open the immediate next container

//On Click
$('.acc_trigger').click(function(){
	if( $(this).next().is(':hidden') ) { //If immediate next container is closed...
		$('.acc_trigger').removeClass('active').next().slideUp(); //Remove all .acc_trigger classes and slide up the immediate next container
		$(this).toggleClass('active').next().slideDown(); //Add .acc_trigger class to clicked trigger and slide down the immediate next container
	}
	return false; //Prevent the browser jump to the link anchor
});

});
</script>
</head>

<body style="background:url(images/bg-0118.png)" onmouseover="checkuser(<%=flag1%>)">
<br> <div id="welcome" align="right"><label><%=username %>，欢迎您！&nbsp;<a href="userAction!withdraw">注销</a>&nbsp;</label></div><br>

<h1>Simple Statistics for <span>PaperPro...</span><small></small></h1>

<div class="container">

	<h2 class="acc_trigger"><a href="#">参考 &amp;原创</a></h2>
	<div class="acc_container">
		<div class="block">
			<h3>两种类别的统计</h3>
			<img src="images/img1.gif" alt="" />
			<s:property value="info1"></s:property>			
		</div>
	</div>
	
	<h2 class="acc_trigger"><a href="#">下载量</a></h2>
	<div class="acc_container">
		<div class="block">
			<h3>哪篇热门？</h3>
			<img src="images/img2.gif" alt="" />
			<s:property value="info2"></s:property>
		</div>
	</div>
	
	<h2 class="acc_trigger"><a href="#">科研考核分数</a></h2>
	<div class="acc_container">
		<div class="block">
			<h3>有高有低...</h3>
			<img src="images/img3.gif" alt="" />
			<s:property value="info3"></s:property>
		</div>
	</div>
	
	<h2 class="acc_trigger"><a href="#">详细类别</a></h2>
	<div class="acc_container">
		<div class="block">
			<h3>享你所想</h3>
			<img src="images/img4.gif" alt="" />
			<s:property value="info4"></s:property>
		</div>
	</div>
	
</div>
<br><center><a href="index.jsp">返回上一页</a></center><br>
 <script>
function checkuser(flag1)
{
	if(flag1==0)
	{
		document.getElementById("welcome").style.display = "none";
	}
	else
	{
		document.getElementById("welcome").style.display = "block";
	}	
}
</script>
</html>
