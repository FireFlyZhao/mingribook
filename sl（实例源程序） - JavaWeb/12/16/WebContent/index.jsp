<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>根据当前的星期显示不同的提示信息</title>
</head>
<body>
<!-- 获取星期并保存到变量中 -->
<c:set var="week">
	<%=new java.util.Date().getDay()%>
</c:set>
<c:choose>
	<c:when test="${week==0 || week==6}">今天是休息日，放松一下心情吧！</c:when>
	<c:when test="${week==1}" >新的一周开始了，努力学习吧！</c:when>
	<c:otherwise>继续努力学习吧！</c:otherwise>
</c:choose>
</body>
</html>