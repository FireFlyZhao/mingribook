<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'index.jsp' starting page</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	</head>

	<body>
		����5�Ľ׳˲���JSPҳ���������
		<br>
		<%
			String str = "";
			int n = 5;
			long result = 1;
			if ((n < 0) || (n > 17)) {
				str = "n��ȡֵ��Χ��0��17������17�ᳬ��long���ͷ�Χ";
			} else if (n == 0) {
				str = "0�Ľ׳˵���1";
			} else {
				for (int i = n; i > 0; i--) {
					result *= i;
				}
				str = n + "�Ľ׳˵��ڣ�" + result;
			}
		%>
		<%=str %>
	</body>
</html>
