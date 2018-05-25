<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>page对象各方法的应用</title>
</head>
<body>
<%!	Object object; 	//声明一个Object型的变量		%>
<ul>
<li>getClass()方法的返回值:<%=page.getClass()%></li>
<li>hashCode()方法的返回值:<%=page.hashCode()%></li>
<li>toString()方法的返回值:<%=page.toString()%></li>
<li>与Object对象比较的返回值:<%=page.equals(object)%></li>
<li>与this对象比较的返回值:<%=page.equals(this)%></li>
</ul>
</body>
</html>