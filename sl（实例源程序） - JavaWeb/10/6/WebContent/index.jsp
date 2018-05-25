<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>首页</title>
</head>
<body>
	<jsp:useBean id="batch" class="com.lyq.Batch"></jsp:useBean>
	<%
		// 执行批量插入操作
		int row = batch.saveBatch();
		out.print("批量插入了【" + row + "】条数据！");
	%>
</body>
</html>