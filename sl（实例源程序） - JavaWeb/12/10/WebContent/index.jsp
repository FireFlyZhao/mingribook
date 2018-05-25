<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>实现分时问候</title>
</head>
<body>
<!-- 获取小时并保存到变量中 -->
<c:set var="hours">
	<%=new java.util.Date().getHours()%>
</c:set>
<!-- 获取分钟并保存到变量中-->
<c:set var="second">
	<%=new java.util.Date().getMinutes()%>
</c:set>
<c:choose>
	<c:when test="${hours>1 && hours<6}">早上好！</c:when>
	<c:when test="${hours>6 && hours<11}" >上午好！</c:when>
	<c:when test="${hours>11 && hours<17}">下午好！</c:when>
	<c:when test="${hours>17 && hours<24}">晚上好！</c:when>
</c:choose>
 现在时间是：${hours}:${second}
</body>
</html>
