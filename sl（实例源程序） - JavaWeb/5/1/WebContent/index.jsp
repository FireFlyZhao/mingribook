<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
    <%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>一个简单的JSP页面——显示系统时间</title>
</head>
<body>
<%
	Date date = new Date(); //获取日期对象
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //设置日期时间格式
	String today = df.format(date); //获取当前系统日期
%>
当前时间：<%=today%>		<!-- 输出系统时间 -->
</body>
</html>