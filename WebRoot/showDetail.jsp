<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page import="lgq.model.User" %>
<%@page import="com.opensymphony.xwork2.ActionContext;" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
			User user=(User)ActionContext.getContext().getSession().get("user");
			String username="";
			int flag=0;
			if(user!=null)
			{
				username=user.getUsername();
				flag=1;
			}
		 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Show Detail</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body onmouseover="checkuser(<%=flag%>)" style="background:url(images/bg-0118.png)">
  <br> <div id="welcome" align="right"><label><%=username %>，欢迎您！&nbsp;<a href="userAction!withdraw">注销</a>&nbsp;</label></div><br>
  <center><h1>论文详细信息</h1></center>
  <div style="padding:20px 10px 40px 10px;
    color:#000;
    font-size: 16px;
	font-family:楷体;
    background-color:#fff;
	foreground-color:#F90;
    font-weight:normal;
    width:500px;
    margin:50px;
    position:absolute;
    left:50px;
    top:90px;
    height:600px;
    border-right:1px dotted #666;
    border-top:7px solid #6f3;
    border-left:5px solid #6f3;
    -moz-box-shadow:0px -1px 4px #000;
    -webkit-box-shadow:0px -1px 4px #000;
    ">
    <div style="margin-left:-50px;
         margin-top:-80px;
         background:url(images/hit.jpg) no-repeat;
         height:100px;"></div>
   <br><br><ul>
  		<li>【题目】&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="paper.title"/></li><br>
  		<li>【作者】&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="paper.author"/></li><br>
  		<li>【上传者】&nbsp;&nbsp;<s:property value="paper.userId"/></li><br>
  		<li>【发表年份】<s:property value="paper.year"/></li><br>
  		<li>【发表月份】<s:property value="paper.month"/></li><br>
  		<li>【科研分数】<s:property value="paper.score"/></li><br>
  		<li>【关键字】&nbsp;&nbsp;<s:property value="paper.keyWord"/></li><br>
  		<li>【下载次数】<s:property value="paper.downloadTimes"/></li><br>
  		<li>【会议名称】<s:property value="paper.name"/></li><br>
  		<li>【期刊名称】<s:property value="paper.name"/></li><br>
  		<li>【会议届别】<s:property value="info1"/></li>
  		
  	</ul>
  	<center>
  <s:url id="url3" action="updateHelpA">
		<s:param name="articleId" value="paper.articleId"></s:param>
	</s:url>
	<s:a href="%{url3}" style="text-decoration:none">
		修改<img src="images/change.png"/>
	</s:a>
	<br><br><a href="javascript:history.back(-1)">返回上一页</a></center></div>
	
	<div style="padding:20px 10px 40px 10px;
    color:#000;
    font-size: 16px;
	font-family:楷体;
    background-color:#fff;
    font-weight:normal;
    width:500px;
    margin:50px;
    border-right:1px dotted #666;
    border-top:7px solid #6f3;
    border-left:5px solid #6f3;
    -moz-box-shadow:0px -5px 10px #000;
    position:absolute;
    right:50px;
    top:90px;
    height:600px;
    -webkit-box-shadow:0px -1px 4px #6f3;
    ">
   <br><br><ul>
  		<li>【举办地点】<s:property value="info2"/></li><br>
  		<li>【期/卷】<s:property value="info1"/></li><br>
  		<li>【始末页】<s:property value="info2"/></li><br>
  		<li>【SCI收录号】<s:property value="paper.sci"/></li><br>
  		<li>【EI收录号】<s:property value="paper.ei"/></li><br>
  		<li>【ISTP收录号】<s:property value="paper.istp"/></li><br>
  		<li>【SCI影响因子】<s:property value="info3"/></li><br>
  		<li>
  			论文分类信息：<br>&nbsp;计算机科学与技术<br>&nbsp;&nbsp;&nbsp;<img src="images\type.png">
  			<s:property value="paper.type1"/><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="images\type.png">
  			<s:property value="paper.type2"/>
  		</li><br>
  	</ul><br>
  	<center>
	<s:url id="url4" action="deletePaperA">
		<s:param name="articleId" value="paper.articleId"></s:param>
	</s:url>
	<s:a href="%{url4}" style="text-decoration:none" onclick="return confirm('你确定要删除这篇论文吗？');">
		删除<img src="images/delete.png"/>
	</s:a><br><br><a href="javascript:history.back(-1)">返回上一页</a></center></div>
	 <script>
function checkuser(flag)
{
	if(flag==0)
	{
		document.getElementById("welcome").style.display = "none";
	}
	else
	{
		document.getElementById("welcome").style.display = "block";
	}	
}
</script>
  </body>
</html>
