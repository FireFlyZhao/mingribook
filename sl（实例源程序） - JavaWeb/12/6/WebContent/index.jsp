<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>应用&lt;c:url&gt;标签生成带参数的URL地址</title>
</head>
<body>
<c:url var="path" value="register.jsp" scope="page">
	<c:param name="user" value="mr"/>
	<c:param name="email" value="wgh717@sohu.com"/>
</c:url>
<a href="${pageScope.path }">提交注册</a>
</body>
</html>
