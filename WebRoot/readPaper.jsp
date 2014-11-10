<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>ReadPaper</title>
    <script type="text/javascript" src="js/pdfobject.js"></script>
    <script type="text/javascript">
      window.onload = function (){
        var myPDF = new PDFObject({ url: "temp.pdf" }).embed("mydiv");
      };
      function reloadPage()
      {
      	window.location.reload();
      }
    </script>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
  </head>
  
  <body >
  <div style="background:lightgray;position:absolute;left:20;top:expression((body.clientHeight-600)/2);width:350;height:600;">
   <br><br><ul>
  		<li>【题目】&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="paper.title"/></li>
  		<li>【作者】&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="paper.author"/></li>
  		<li>【上传者】&nbsp;&nbsp;<s:property value="paper.userId"/></li>
  		<li>【发表年份】<s:property value="paper.year"/></li>
  		<li>【发表月份】<s:property value="paper.month"/></li>
  		<li>【科研分数】<s:property value="paper.score"/></li>
  		<li>【关键字】&nbsp;&nbsp;<s:property value="paper.keyWord"/></li>
  		<li>【下载次数】<s:property value="paper.downloadTimes"/></li>
  		<li>【会议名称】<s:property value="paper.name"/></li>
  		<li>【期刊名称】<s:property value="paper.name"/></li>
  		<li>【会议届别】<s:property value="info1"/></li>
  		<li>【举办地点】<s:property value="info2"/></li>
  		<li>【期/卷】<s:property value="info1"/></li>
  		<li>【始末页】<s:property value="info2"/></li>
  		<li>【SCI收录号】<s:property value="paper.sci"/></li>
  		<li>【EI收录号】<s:property value="paper.ei"/></li>
  		<li>【ISTP收录号】<s:property value="paper.istp"/></li>
  		<li>【SCI影响因子】<s:property value="info3"/></li>
  		<li>
  			论文分类信息：<br>&nbsp;计算机科学与技术<br>&nbsp;&nbsp;&nbsp;<img src="images\type.png">
  			<s:property value="paper.type1"/><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="images\type.png">
  			<s:property value="paper.type2"/>
  		</li>
  	</ul>
  <center> 
  <s:url id="url3" action="updateHelpA">
		<s:param name="articleId" value="paper.articleId"></s:param>
	</s:url>
	<s:a href="%{url3}" style="text-decoration:none">
		修改<img src="images/change.png"/>
	</s:a>
	<s:url id="url4" action="deletePaperA">
		<s:param name="articleId" value="paper.articleId"></s:param>
	</s:url>
	<s:a href="%{url4}" style="text-decoration:none" onclick="return confirm('你确定要删除这篇论文吗？');">
		删除<img src="images/delete.png"/>
	</s:a>
  <br><a href="javascript:history.back(-1)">返回上一页</a>
  </center>
   </div>
  <div style="background:gray;position:absolute;right:20;top:expression((body.clientHeight-600)/2);width:800;height:600;border=10,20,10,20;" id="mydiv">
 </div>
  </body>
</html>
