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
    
    <title>我的首页</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="css/style.css" type="text/css" media="screen"/>
	<link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/searchStyle.css" media="screen" type="text/css" />
  </head>
  
      <body>
        <div class="container">
        <br>
         <center><h1>PaperPro:论文管理系统</h1></center>
            <ul id="menu">
                <li>
                    <a href="upload.jsp?flag=0" style="text-decoration:none">
                        <i class="icon_about"></i>
                        <span class="title">我要上传</span>
                        <span class="description">上传参考论文，增加我们的储备量。</span>
                    </a>
                </li>
                <li>
                    <a href="upload.jsp?flag=1" style="text-decoration:none">
                        <i class="icon_work"></i>
                        <span class="title">我要发表</span>
                        <span class="description">发表原创论文，参与工作量考核。</span>
                    </a>
                </li>
                <li>
                    <a href="dataStatistic.jsp" style="text-decoration:none">
                        <i class="icon_help"></i>
                        <span class="title">数据统计</span>
                        <span class="description">查看我们的统计数据。</span>
                    </a>
                </li>
                <li>
                    <a href="goodLuckA" style="text-decoration:none">
                        <i class="icon_search" ></i>
                        <span class="title">手气不错</span>
                        <span class="description">试试看，没准就有你想要的文章呢。</span>
                    </a>
                </li>
                </ul>
        </div>
		<div align="right">
		<a href="login.jsp">登陆</a>
		<a href="register.jsp">注册</a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</div>
		
<section class="webdesigntuts-workshop">
	<form action="searchPaperA" class="lgq.action.SearchPaperAction" method="post"> 
		<input placeholder="题目" name="search1">
        <input placeholder="作者" name="search2">
        <input placeholder="关键字" name="search3">
		<input placeholder="发表时间" name="search4">	
		<button>Search</button>
	</form>
</section>

<div style="text-align:center;clear:both">
<script src="/gg_bd_ad_720x90.js" type="text/javascript"></script>
<script src="/follow.js" type="text/javascript"></script>
</div>
        <script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
        <script type="text/javascript">
        $(function() {
            $('#menu > li').hover(
                function () {
                    var $this = $(this);
                    $('a',$this).stop(true,true).animate({
                            'bottom':'-15px'
                        }, 300);
                    $('i',$this).stop(true,true).animate({
                            'top':'-10px'
                        }, 400);
                },
                function () {
                    var $this = $(this);
                    $('a',$this).stop(true,true).animate({
                            'bottom':'-95px'
                        }, 300);
                    $('i',$this).stop(true,true).animate({
                            'top':'50px'
                        }, 400);
                }
            );
        });
        </script>
<div style="position:absolute;height:50px;width:300;left:525;right:100;top:500;text-align:center">
	<a href="#">上传日志</a>&nbsp;
	<a href="#">修改日志</a>&nbsp;
	<a href="#">删除日志</a>
</div>
    </body>
</html>
