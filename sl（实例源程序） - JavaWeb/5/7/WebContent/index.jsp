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
		��JSPҳ�������������ʱ�䣬��ʽΪ������ �� �� ʱ���֣��롱
		<br>
		<%
			Date date = new Date();
			String year = String.format("%tY", date); //��date���и�ʽ��
			String month = String.format("%tm", date);
			String day = String.format("%td", date);
			String hour = String.format("%tH", date); //��date���и�ʽ��
			String minute = String.format("%tM", date);
			String second = String.format("%tS", date);
			String dateStr = year + "��" + month + "��" + day + "�� " + hour + "ʱ"
					+ minute + "��" + second + "��";
		%>
		����ʱ���ǣ�<%=dateStr %>
	</body>
</html>
