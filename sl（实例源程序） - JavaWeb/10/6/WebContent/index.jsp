<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>��ҳ</title>
</head>
<body>
	<jsp:useBean id="batch" class="com.lyq.Batch"></jsp:useBean>
	<%
		// ִ�������������
		int row = batch.saveBatch();
		out.print("���������ˡ�" + row + "�������ݣ�");
	%>
</body>
</html>