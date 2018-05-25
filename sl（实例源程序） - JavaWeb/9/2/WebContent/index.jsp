<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加图书信息</title>
</head>
<body>
	<form action="AddServlet" method="post">
		<table align="center" border="1" width="350">
			<tr>
				<td class="2" align="center" colspan="2">
					<h2>添加图书信息</h2>
				</td>
			</tr>
			<tr>
				<td align="right">图书编号：</td>
				<td>
					<input type="text" name="id">
				</td>
			</tr>
			<tr>
				<td align="right">图书名称：</td>
				<td>
					<input type="text" name="name">
				</td>
			</tr>
			<tr>
				<td align="right">作　　者：</td>
				<td>
					<input type="text" name="author">
				</td>
			</tr>
			<tr>
				<td align="right">价　　格：</td>
				<td>
					<input type="text" name="price">
				</td>
			</tr>
			<tr>
				<td class="2" align="center" colspan="2">
					<input type="submit" value="添　加">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>