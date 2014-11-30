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
        <title>Upload Log</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="description" content="Pimp your tables with CSS3" />
        <meta name="keywords" content="table, css3, style, beautiful, fancy, css"/>
        <link rel="stylesheet" href="css/logstyle.css" type="text/css" media="screen"/>
    </head>
    <style>
        *{
            margin:0;
            padding:0;
        }
        body{
            font-family: Georgia, serif;
            font-size: 16px;
            font-style: italic;
            font-weight: normal;
            letter-spacing: normal;
            background: #f0f0f0;
        }
        #content{
            background-color:#eee;
            width:750px;
            padding:40px;
            margin:0 auto;
            border-left:30px solid #7f7f7f;
            border-right:1px solid #ddd;
            -moz-box-shadow:0px 0px 16px #aaa;
        }
        .head{
            font-family:Helvetica,Arial,Verdana;
            text-transform:uppercase;
            font-weight:bold;
            font-size:12px;
            font-style:normal;
            letter-spacing:3px;
            color:#888;
            border-bottom:3px solid #f0f0f0;
            padding-bottom:10px;
            margin-bottom:10px;
        }
        .head a{
            color:#1D81B6;
            text-decoration:none;
            float:right;
            text-shadow:1px 1px 1px #888;
        }
        .head a:hover{
            color:#f0f0f0;
        }
        #content h1{
            font-family:"Trebuchet MS",sans-serif;
            color:#000000;
            font-weight:normal;
            font-style:normal;
            font-size:36px;
            text-shadow:1px 1px 1px #aaa;
        }
        #content h2{
            font-family:"Trebuchet MS",sans-serif;
            font-size:24px;
            font-style:normal;
            background-color:#fefefe;
            margin:40px 0px 30px -40px;
            padding:0px 40px;
            clear:both;
            float:left;
            width:100%;
            color:#aaa;
            text-shadow:1px 1px 1px #fff;
        }

    </style>
    <body onmouseover="checkuser(<%=flag%>)" style="background:url(images/bg-0118.png)"><br><br>
	<br> <div id="welcome" align="right"><label><%=username %>，欢迎您！&nbsp;<a href="userAction!withdraw">注销</a>&nbsp;&nbsp;&nbsp;</label></div><br>
        <div id="content">
            <span class="scroll"></span>
            <p class="head">

            </p>
            <h1>Upload Log</h1>
            <h2>Detail</h2>
            <table class="table2">
                <thead>
                    <tr>
                        <th></th>
                        <th scope="col" abbr="Starter">上传者</th>
                        <th scope="col" abbr="Medium">论文题目</th>
                        <th scope="col" abbr="Business">论文作者</th>
                        <th scope="col" abbr="Deluxe">上传时间</th>
                    </tr>
                </thead>
                <tbody>
					<s:iterator id="it" value="list1">
						<tr align="center">
                        	<th scope="row"></th>
							<td><s:property value="#it.username"/></td>
							<td><s:property value="#it.title"/></td>
							<td><s:property value="#it.author"/></td>
							<td><s:property value="#it.date"/></td>
						</tr>
					</s:iterator>
                </tbody>
            </table>


        </div>
</table><br><center><a href="javascript:history.back(-1)">返回上一页</a></center>
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