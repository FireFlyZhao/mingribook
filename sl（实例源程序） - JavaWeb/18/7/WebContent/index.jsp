<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/login.do" method="post">
<h3>用户登录</h3>
<table>
	<tr>
		<td>用户名：<input type="text" name="name" style="width:180px"/></td>
	</tr>
	<tr>
		<td>密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password"
			name="password" style="width:180px"/></td>
	</tr>
	<tr>
		<td align="center">
			<input type="submit" value="登录"/>
			<input type="reset" value="取消"/>
		</td>
	</tr>
</table>
</form>
</body>
</html>