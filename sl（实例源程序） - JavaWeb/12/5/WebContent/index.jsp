<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>应用&lt;c:import&gt;标签导入网站Banner</title>
</head>
<body style=" margin:0px;">
<c:set var="typeName" value="流行金曲 | 经典老歌 | 热舞DJ | 欧美金曲 | 少儿歌曲 | 轻音乐 | 最新上榜"/>
<!-- 导入网站的Banner -->
<c:import url="navigation.jsp" charEncoding="UTF-8">
	<c:param name="typeList" value="${typeName}"/>
</c:import>

</body>
</html>