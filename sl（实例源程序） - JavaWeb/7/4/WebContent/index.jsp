<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="reg.jsp" method="post">
		<table align="center" width="400" height="200" border="1">
			<tr>
				<td align="center" colspan="2" height="40">
					<b>添加用户信息</b>
				</td>
			</tr>
			<tr>
				<td align="right">姓　名：</td>
				<td>
					<input type="text" name="name">
				</td>
			</tr>
			<tr>
				<td align="right">年　龄：</td>
				<td>
					<input type="text" name="age">
				</td>
			</tr>
			<tr>
				<td align="right">性　别：</td>
				<td>
					<input type="text" name="sex">
				</td>
			</tr>
			<tr>
				<td align="right">住　址：</td>
				<td>
					<input type="text" name="add">
				</td>
			</tr>
			<tr>
				<td align="center" colspan="2">
					<input type="submit" value="添　加">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>