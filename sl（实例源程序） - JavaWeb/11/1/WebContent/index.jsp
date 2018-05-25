<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String[] arr={"Java Web开发典型模块大全","Java范例完全自学手册","JSP项目开发全程实录"};	//定义一维数组
request.setAttribute("book",arr);		//将数组保存到request对象中
%>
<%
String[] arr1=(String[])request.getAttribute("book");	//获取保存到request范围内的变量
//通过循环和EL输出一维数组的内容
for(int i=0;i<arr1.length;i++){
	request.setAttribute("requestI",i);
%>
	
	${requestI}：${book[requestI]}<br>	<!-- 输出数组中第i个元素 -->
<%} %>

</body>
</html>