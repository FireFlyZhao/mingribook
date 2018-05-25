<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>应用&lt;c:remove&gt;标签移除变量</title>
</head>
<body>
<ul>
<li>定义request范围内的变量username</li>
<br>
<c:set var="username" value="明日科技" scope="request"/>
username的值为：<c:out value="${username}"/>
<li>移除request范围内的变量username</li>
<br>
<c:remove var="username" scope="request"/>
username的值为：<c:out value="${username}" default="空"/>
</ul>
</body>
</html>
