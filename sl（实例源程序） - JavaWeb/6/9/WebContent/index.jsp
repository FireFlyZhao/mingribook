<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" errorPage="error.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>使用exception对象获取异常信息</title>
</head>
<body>
<%
request.setAttribute("price","12.5元");//保存单价到request范围内的变量price中
float price=Float.parseFloat(request.getAttribute("price").toString());	//获取单价，并转换为float型
%>
</body>
</html>