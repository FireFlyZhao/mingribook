<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>计数器</title>
</head>
<body>
	<jsp:useBean id="counter" class="com.lyq.bean.Counter"></jsp:useBean>
	<h2>
		欢迎光临，你是第
		<jsp:getProperty property="count" name="counter"/>
		位来访者。
	</h2>
</body>
</html>