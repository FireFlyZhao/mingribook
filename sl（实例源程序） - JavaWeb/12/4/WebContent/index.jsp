<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>应用&lt;c:catch&gt;标签捕获异常信息</title>
</head>
<body>
<c:catch var="error">
	<jsp:useBean class="com.wgh.UserInfo" id="userInfo"/>
	<c:set target="${userInfo}" property="pwd">111</c:set>
</c:catch>
<c:out value="${error}"/>
</body>
</html>