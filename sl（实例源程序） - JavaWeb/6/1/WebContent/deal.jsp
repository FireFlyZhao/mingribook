<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="utf-8"%>
<%
String id=request.getParameter("id");	//获取id参数的值
String user=request.getParameter("user");//获取user参数的值
String pwd=request.getParameter("pwd");//获取pwd参数值
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>处理页</title>
</head>
<body>
id参数的值为：<%=id %><br>
user参数的值为：<%=user %><br>
pwd参数的值为：<%=pwd %>
</body>
</html>