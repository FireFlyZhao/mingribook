<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>重定向页面并传递参数</title>
</head>
<body>
<c:redirect url="main.jsp">
	<c:param name="user" value="cdd"/>
</c:redirect>
</body>
</html>