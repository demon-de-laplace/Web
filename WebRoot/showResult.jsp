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
    
    <title>Show Result</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body><br><br>
  <center><h1>查询结果</h1></center>
    	<table align="center" width="1200" border="1">
	<tr>
		<td align="center" colspan="16">
			<h4>期刊论文信息</h4>
		</td>
	</tr>
	<tr align="center">
			<th><b>题目</b></th>
			<th><b>作者</b></th>
			<th><b>上传者</b></th>
			<th><b>论文类别</b></th>
			<th><b>发表年份</b></th>
			<th><b>发表月份</b></th>
			<th><b>关键字</b></th>
			<th><b>期刊名称</b></th>
			<th><b>期卷</b></th>
			<th><b>始末页</b></th>
			<th><b>SCI收录号</b></th>
			<th><b>EI收录号</b></th>
			<th><b>ISTP收录号</b></th>
			<th><b>科研分数</b></th>
			<th><b>下载次数</b></th>
			<th><b>操作</b></th>
		</tr>
	<s:iterator id="it" value="list1">
		<tr align="center">
			<td>
				<s:url id="url" action="showDetailA">
				<s:param name="articleId" value="#it.articleId"></s:param>
				</s:url>
				<s:a href="%{url}" style="text-decoration:none"><s:property value="#it.Title"/></s:a>
			</td>
			<td><s:property value="#it.author"/></td>
			<td><s:property value="#it.userId"/></td>
			<td><s:property value="#it.type1"/></td>
			<td><s:property value="#it.year"/></td>
			<td><s:property value="#it.month"/></td>
			<td><s:property value="#it.keyWord"/></td>
			<td><s:property value="#it.name"/></td>
			<td><s:property value="#it.otherInfo"/></td>
			<td><s:property value="#it.otherInfo"/></td>
			<td><s:property value="#it.sci"/></td>
			<td><s:property value="#it.ei"/></td>
			<td><s:property value="#it.istp"/></td>
			<td><s:property value="#it.score"/></td>
			<td><s:property value="#it.downloadTimes"/></td>
			<td>
				<s:url id="url1" action="readPaperA">
					<s:param name="articleId" value="#it.articleId"></s:param>
				</s:url>
				<s:a href="%{url1}" style="text-decoration:none">
				<img src="images/read.png"/>
				</s:a>
				<s:url id="url2" action="downloadA">
					<s:param name="articleId" value="#it.articleId"></s:param>
				</s:url>
				<s:a href="%{url2}" style="text-decoration:none">
					<img src="images/download.png"/>
				</s:a>
				<s:url id="url3" action="updateHelpA">
					<s:param name="articleId" value="#it.articleId"></s:param>
				</s:url>
				<s:a href="%{url3}" style="text-decoration:none">
					<img src="images/change.png"/>
				</s:a>
				<s:url id="url4" action="deletePaperA">
				<s:param name="articleId" value="#it.articleId"></s:param>
				</s:url>
				<s:a href="%{url4}" style="text-decoration:none" onclick="return confirm('你确定要删除这篇论文吗？');">
					<img src="images/delete.png"/>
				</s:a>
			</td>
		</tr>
	</s:iterator>
</table><br><br>
<table align="center" width="1200" border="1">
	<tr>
		<td align="center" colspan="16">
			<h4>会议论文信息</h4>
		</td>
	</tr>
	<tr align="center">
			<th><b>题目</b></th>
			<th><b>作者</b></th>
			<th><b>上传者</b></th>
			<th><b>论文类别</b></th>
			<th><b>发表年份</b></th>
			<th><b>发表月份</b></th>
			<th><b>关键字</b></th>
			<th><b>会议名称</b></th>
			<th><b>会议届别</b></th>
			<th><b>举办地</b></th>
			<th><b>SCI收录号</b></th>
			<th><b>EI收录号</b></th>
			<th><b>ISTP收录号</b></th>
			<th><b>科研分数</b></th>
			<th><b>下载次数</b></th>
			<th><b>操作</b></th>
		</tr>
	<s:iterator id="it" value="list2">
		<tr align="center">
			<td>
				<s:url id="urlt" action="showDetailA">
				<s:param name="articleId" value="#it.articleId"></s:param>
				</s:url>
				<s:a href="%{urlt}" style="text-decoration:none"><s:property value="#it.Title"/></s:a>
			</td>
			<td><s:property value="#it.author"/></td>
			<td><s:property value="#it.userId"/></td>
			<td><s:property value="#it.type1"/></td>
			<td><s:property value="#it.year"/></td>
			<td><s:property value="#it.month"/></td>
			<td><s:property value="#it.keyWord"/></td>
			<td><s:property value="#it.name"/></td>
			<td><s:property value="#it.otherInfo"/></td>
			<td><s:property value="#it.otherInfo"/></td>
			<td><s:property value="#it.sci"/></td>
			<td><s:property value="#it.ei"/></td>
			<td><s:property value="#it.istp"/></td>
			<td><s:property value="#it.score"/></td>
			<td><s:property value="#it.downloadTimes"/></td>
			<td>
				<s:url id="url1t" action="readPaperA">
					<s:param name="articleId" value="#it.articleId"></s:param>
				</s:url>
				<s:a href="%{url1t}" style="text-decoration:none">
				<img src="images/read.png"/>
				</s:a>
				<s:url id="url2t" action="downloadA">
					<s:param name="articleId" value="#it.articleId"></s:param>
				</s:url>
				<s:a href="%{url2t}" style="text-decoration:none">
					<img src="images/download.png"/>
				</s:a>
				<s:url id="url3t" action="updateHelpA">
					<s:param name="articleId" value="#it.articleId"></s:param>
				</s:url>
				<s:a href="%{url3t}" style="text-decoration:none">
					<img src="images/change.png"/>
				</s:a>
				<s:url id="url4t" action="deletePaperA">
				<s:param name="articleId" value="#it.articleId"></s:param>
				</s:url>
				<s:a href="%{url4t}" style="text-decoration:none" onclick="return confirm('你确定要删除这篇论文吗？');">
					<img src="images/delete.png"/>
				</s:a>
			</td>
		</tr>
	</s:iterator>
</table><br><br>
<div align="right">注：科研分数为-1.0的表明这篇论文为参考论文，不是用户的原创论文，不参与科研分数考核。</div><br>
<center>
	<a href="toExcel.jsp">将查询结果导出为Excel</a>
	<a href="javascript:history.back(-1)">返回</a>
</center>
  </body>
</html>
