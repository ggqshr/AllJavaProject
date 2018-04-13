<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Calculator</title>
</head>
<body>
<jsp:useBean id="calculator" class="entity.Calculator" />
<jsp:setProperty property="*" name="calculator"/>
<%
	if(calculator.validate())
	{
%>
<font color="green">
运算结果：
<jsp:getProperty property="fristNumber" name="calculator"/>
<jsp:getProperty property="operator" name="calculator"/>
<jsp:getProperty property="secondNumber" name="calculator"/>
=<%= calculator.calculator()  %>
</font>
<%
	}else{
		HashMap<String,String> errors = calculator.getErrors();
		pageContext.setAttribute("errors", errors);
	}
%>
<form action="" method="post">
第一个运算数：<input type="text" name="fristNumber" />
<font color="red">${error.get(fristNumber)}</font><br>
运算符：<select name="operator" style="margin-left:100px">
<option value="+">+</option>
<option value="-">-</option>
<option value="*">*</option>
<option value="/">/</option>
</select><br>
第二个运算数：<input type="text" name="secondNumber"/>
<font color="red">${error.get(secondNumber)}</font><br>
<input type="submit" value="提交"/>
</form>
</body>
</html>