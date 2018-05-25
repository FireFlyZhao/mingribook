<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>电子时钟</title>
<style type="text/css">
	#clock{
		width:420px;
		height:80px;
		background:#E0E0E0;
		font-size: 25px;
		font-weight: bold;
		border: solid 5px orange;
		padding: 20px;
	}
	#week{
		padding-top:15px;
		color: #0080FF;
	}
</style>
<meta http-equiv="Refresh" content="1">
</head>
<body>
	<jsp:useBean id="date" class="com.lyq.bean.DateBean" scope="application"></jsp:useBean>
	<div align="center">
		<div id="clock">
			<div id="time">
				<jsp:getProperty property="dateTime" name="date"/>
			</div>
			<div id="week">
				<jsp:getProperty property="week" name="date"/>
			</div>
		</div>
	</div>
</body>
</html>