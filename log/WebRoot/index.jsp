<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
   <h1>登陆界面</h1>
   <a href="#"><img src="IMG/104122-106.jpg"></a>
   <form action="servlet/log" method="post">
   <p>
   <label>用户名:</label>
   <input type="username" name ="username" >
   <label>&nbsp;&nbsp;密码</label>
   <input type="password" name ="password" >
   </p>
   <p>
   <input type="submit" value="提交">
   </p>
   </form>
  </body>
</html>
