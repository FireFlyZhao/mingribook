<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>应用&lt;c:forTokens&gt;分隔字符串</title>
</head>
<body>
<c:set var="sourceStr" value="Java Web：程序开发范例宝典、典型模块大全；Java：实例完全自学手册、典型模块大全"/>
<b>原字符串：</b><c:out value="${sourceStr}"/>
<br><b>分割后的字符串：</b><br>
<c:forTokens items="${sourceStr}" delims="：、；" var="item">
	${item}<br>
</c:forTokens>
</body>
</html>
