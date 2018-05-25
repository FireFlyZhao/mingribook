<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>幸运大抽奖</title>
</head>
<body>
<%Random rnd=new Random();%>
<!-- 将抽取的幸运数字保存到变量中 -->
<c:set var="luck">
	<%=rnd.nextInt(10)%>
</c:set>
<c:choose>
	<c:when test="${luck==6}">恭喜你，中了一等奖！</c:when>
	<c:when test="${luck==7}" >恭喜你，中了二等奖！</c:when>
	<c:when test="${luck==8}">恭喜你，中了三等奖！</c:when>
	<c:otherwise>谢谢您的参与！</c:otherwise>
</c:choose>
</body>
</html>
