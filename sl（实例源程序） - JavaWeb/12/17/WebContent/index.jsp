<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%String[] arr={"苹果","香蕉","荔枝","芒果"}; 
request.setAttribute("arrFruit",arr);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>显示数组中的数据</title>
</head>
<body>
<c:forEach items="${requestScope.arrFruit}" var="fruit" varStatus="id">
	${id.index }&nbsp;${fruit}<br>
</c:forEach>
</body>
</html>