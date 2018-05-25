<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>用户注册</title>
</head>
<body>

<form action="RegServlet" method="post">
	<table align="center" width="450">
		<tr>
			<td align="center" colspan="2">
				<h2>用户注册</h2>
				<hr>
			</td>
		</tr>
		<tr>
			<td align="right">用户名：</td>
			<td><input type="text" name="name" /></td>
		</tr>
		<tr>
			<td align="right">密码：</td>
			<td><input type="password" name="password" /></td>
		</tr>
		<tr>
			<td align="right">性别：</td>
			<td>
				<input type="radio" name="sex" value="男" checked="checked">男
				<input type="radio" name="sex" value="女">女
			</td>
		</tr>
		<tr>
			<td align="right">QQ号码：</td>
			<td><input type="text" name="qq" /></td>
		</tr>
		<tr>
			<td align="right">E-Mail地址：</td>
			<td><input type="text" name="mail" /></td>
		</tr>
		<tr>
			<td align="center" colspan="2">
				<input type="submit" value="注　册">
			</td>
		</tr>
	</table>
</form>
</body>
</html>