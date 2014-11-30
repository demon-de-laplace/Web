<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>结果</title>
</head>
<body style="background:url(images/bg-0118.png)">
<center>
<br><br><br>
<h3>
<s:property value="info"/>
<script type="text/javascript">setTimeout("history.go(-1)", 2000);  </script>
<SCRIPT language=javascript>
	var i=2;
	var intervalid; 
	intervalid = setInterval("back()", 1000); 
	function go()
	{
		if(i==0)
		{
			window.history.go(-1);
			clearInterval(intervalid);
		}
		document.getElementById("mes").innerHTML = i; 
		i--;
	}
	setTimeout("go()",2000);
</SCRIPT>
将在 <span id="mes">2</span> 秒钟后返回首页。

</h3>
</center>
</body>
</html>