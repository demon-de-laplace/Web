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
    
    <title>Change Paper Info</title>
    
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
    <div style="position:absolute;left:20;top:20;width:350;height:600;">
   <br><br><h2><b>原论文信息</b></h2><ul>
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
  		<li>【SCI收录号】<s:property value="paper.sci"/></li>
  		<li>【EI收录号】<s:property value="paper.ei"/></li>
  		<li>【ISTP收录号】<s:property value="paper.istp"/></li>
  		<li>【SCI影响因子】<s:property value="info3"/></li>
  		<li>
  			【论文分类信息】<br>&nbsp;计算机科学与技术<br>&nbsp;&nbsp;&nbsp;<img src="images\type.png">
  			<s:property value="paper.type1"/><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="images\type.png">
  			<s:property value="paper.type2"/>
  		</li>
  	</ul>
  
   </div>
   <div style="position:absolute;left:400;top:20;"><br><br>
   <h2><b>修改信息</b></h2>
   <s:form action="updatePaperA" class="lgq.action.UpdatePaperAction" method="post" name="form1">
   		<s:textfield name="articleId" value="%{paper.articleId}" label="论文编号"></s:textfield>
  		<s:textfield name="title" label="题目" value="%{paper.title}"></s:textfield>
  		<s:select name="authorNum" label="作者数目" list="{'1','2','3','4'}" value="%{paper.authorNum}"></s:select>
  		<s:textfield name="author1" label="第一作者"></s:textfield>
  		<s:textfield name="author2" label="第二作者"></s:textfield>
  		<s:textfield name="author3" label="第三作者"></s:textfield>
  		<s:textfield name="author4" label="第四作者"></s:textfield>
  		<s:textfield name="name" label="期刊名称/会议名称" value="%{paper.name}" ></s:textfield>
  		期刊详细信息<br>
  		<s:textfield name="phase" label="期"></s:textfield>
  		<s:textfield name="volume" label="卷"></s:textfield>
  		<s:textfield name="beginPage" label="开始页"></s:textfield>
  		<s:textfield name="endPage" label="结束页"></s:textfield>
  		
  		<div style="width:400">
  		<s:label>会议详细信息</s:label><br>
  		<s:textfield name="num" label="会议届别"></s:textfield>
  		<s:textfield name="location" label="举办地点"></s:textfield>
  		</div>
  		<s:select name="year" label="发表时间（年）" value="%{paper.year}" list="{'2000','2001','2002','2003','2004','2005','2006','2007','2008','2009','2010','2011','2012','2013','2014','2015','2016','2017'}"></s:select>
  		<s:select name="month" label="发表时间（月）" value="%{paper.month}" list="{'1','2','3','4','5','6','7','8','9','10','11','12'}"></s:select>
  		<s:textfield name="sci" label="SCI收录号" value="%{paper.sci}"></s:textfield>
  		<s:textfield name="ei" label="EI收录号" value="%{paper.ei}"></s:textfield>
  		<s:textfield name="istp" label="ISTP收录号" value="%{paper.istp}"></s:textfield>
  		
  		<div style="text-align:left;width:400">
  		SCI影响因子<br>
  		<input type="radio" name="effect" value="level1">领域顶级期刊论文或影响因子处在最高20%的期刊<br>
  		<input type="radio" name="effect" value="level2">SCI影响因子(IF)>1.0<br>
  		<input type="radio" name="effect" value="level3">0.1≤SCI影响因子(IF)<1.0<br>
  		<input type="radio" name="effect" value="level4">SCI影响因子(IF)<0.1<br>
  		<input type="radio" name="effect" value="level5">无
  		</div>
  		<s:textfield name="keyWord" label="关键字"></s:textfield>
  		<s:select label="父类别" name="type1"  size="1" onChange="redirect(this.options.selectedIndex)"list="{'期刊论文','会议论文'}"/> 
		<s:select label="子类别" name="type2" size="1" list="{'SCI索引论文','EI索引论文','非SCI/EI索引国外期刊','非SCI/EI索引国内一级期刊','非SCI/EI索引国内核心期刊','非SCI/EI索引国内一般期刊'}"/> 
  		<s:submit value="修改"></s:submit>
  	</s:form>

   </div>
  <script> 
	var groups=document.form1.type1.options.length ;
	var group=new Array(groups) ;
	for (var i=0; i<groups; i++) 
		group[i]=new Array() ;
	group[0][0]=new Option("SCI索引论文") ;
	group[0][1]=new Option("EI索引论文") ;
	group[0][2]=new Option("非SCI/EI索引国外期刊") ;
	group[0][3]=new Option("非SCI/EI索引国内一级期刊") ;
	group[0][4]=new Option("非SCI/EI索引国内核心期刊") ;
	group[0][5]=new Option("非SCI/EI索引国内一般期刊") ;
	group[1][0]=new Option("国际CCF A类会议") ;
	group[1][1]=new Option("国际CCF B类会议") ;
	group[1][2]=new Option("国际CCF C类会议") ;
	group[1][3]=new Option("国际其它类会议") ;
	group[1][4]=new Option("国内会议") ;
	var temp=document.form1.type2 ;
	function redirect(x){ 
		for (var m=temp.options.length-1;m>0;m--) 
			temp.options[m]=null ;
		for (var i=0;i<group[x].length;i++){ 
			temp.options[i]=new Option(group[x][i].text,group[x][i].value) ;
		} 
	temp.options[0].selected=true ;
	} 
</script> 
<center> 
  <br><a href="javascript:history.back(-1)">返回上一页</a>
  </center>
  </body>
</html>
