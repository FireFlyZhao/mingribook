<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>录入商品信息</title>
</head>
<body>
	<form action="AddServlet" method="post" onsubmit="return check(this);">
	<table align="center" width="450">
		<tr>
			<td align="center" colspan="2">
				<h2>录入商品信息</h2>
				<hr>
			</td>
		</tr>
		<tr>
			<td align="right">名称：</td>
			<td><input type="text" name="name" /></td>
		</tr>
		<tr>
			<td align="right">价格：</td>
			<td><input type="text" name="price" /></td>
		</tr>
		<tr>
			<td align="right">数量：</td>
			<td><input type="text" name="count" /></td>
		</tr>
		<tr>
			<td align="right">单位：</td>
			<td><input type="text" name="unit" /></td>
		</tr>
		<tr>
			<td align="right">产地：</td>
			<td><input type="text" name="add" /></td>
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