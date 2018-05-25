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
		在JSP页面中输出字符“*”组成的金字塔。
		<br>
		<%
			String str = "";
			for (int i = 0; i < 15; i++) {
				for (int j = 15; j > i; j--) {
					str += "&nbsp;";
				}
				for (int j = 0; j < i; j++) {
					str += "*&nbsp;";
				}
				str += "<br>";
			}
		%>
		<%=str%>
	</body>
</html>
