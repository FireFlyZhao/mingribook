<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>������</title>
</head>
<body>
	<jsp:useBean id="counter" class="com.lyq.bean.Counter"></jsp:useBean>
	<h2>
		��ӭ���٣����ǵ�
		<jsp:getProperty property="count" name="counter"/>
		λ�����ߡ�
	</h2>
</body>
</html>