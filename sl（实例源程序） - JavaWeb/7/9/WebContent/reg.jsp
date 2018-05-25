<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>注册信息</title>
</head>
<body>
<%request.setCharacterEncoding("GB18030"); %>
<jsp:useBean id="user" class="com.lyq.bean.User">
	<jsp:setProperty property="*" name="user"/>
</jsp:useBean>
<table align="center" width="400">
	<tr>
		<td align="right">姓　名：</td>
		<td>
			<jsp:getProperty property="name" name="user"/>
		</td>
	</tr>
	<tr>
		<td align="right">密　码：</td>
		<td>
			<jsp:getProperty property="password" name="user"/>
		</td>
	</tr>
	<tr>
		<td align="right">性　别：</td>
		<td>
			<jsp:getProperty property="sex" name="user"/>
		</td>
	</tr>
	<tr>
		<td align="right">QQ号码：</td>
		<td>
			<jsp:getProperty property="qq" name="user"/>
		</td>
	</tr>
	<tr>
		<td align="right">E-Mail地址：</td>
		<td>
			<jsp:getProperty property="mail" name="user"/>
		</td>
	</tr>
</table>
</body>
</html>