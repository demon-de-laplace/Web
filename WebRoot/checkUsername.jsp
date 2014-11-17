	<%@ page import="model.UserDao" %>
	<%
	//out.print("123456");
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html");
	response.setCharacterEncoding("utf-8");
	String username=request.getParameter("username");
	String message="";
	UserDao userDao =new UserDao();
	if(userDao.isUnique(username)){ message="{msg:true}" ;
	}else{
	message="{msg:false}" ;
	}
	out.print(message);
	out.close();
%>