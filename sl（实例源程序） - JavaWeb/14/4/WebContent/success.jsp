<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>运行结果</title>
<style type="text/css">
* {
	font-size: 12px;
}
</style>
</head>
<body>
request范围内的info值：
<font color="red"> <%=request.getAttribute("info")%></font>
<br>
session范围内的info值：
<font color="red"><%=session.getAttribute("info")%></font>
<br>
application范围内的info值：
<font color="red"><%=application.getAttribute("info")%></font>
<br>
</body>
</html>