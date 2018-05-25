<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>遍历List集合</title>
</head>
<body>
<%
List<String> list=new ArrayList<String>();							//创建List集合的对象
list.add("简单是可靠的先决条件");								//向List集合中添加元素
list.add("兴趣是最好的老师");
list.add("知识上的投资总能得到最好的回报");
request.setAttribute("list",list);									//将List集合保存到request对象中
%>
<b>遍历List集合的全部元素：</b><br>
<c:forEach items="${requestScope.list}" var="keyword" varStatus="id">
	${id.index }&nbsp;${keyword}<br>
</c:forEach>
<b>遍历List集合中第1个元素以后的元素（不包括第1个元素）：</b><br>
<c:forEach items="${requestScope.list}" var="keyword" varStatus="id" begin="1">
	${id.index }&nbsp;${keyword}<br>
</c:forEach>
</body>
</html>
