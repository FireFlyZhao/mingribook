<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>¼����Ʒ��Ϣ</title>
</head>
<body>
	<form action="AddServlet" method="post" onsubmit="return check(this);">
	<table align="center" width="450">
		<tr>
			<td align="center" colspan="2">
				<h2>¼����Ʒ��Ϣ</h2>
				<hr>
			</td>
		</tr>
		<tr>
			<td align="right">���ƣ�</td>
			<td><input type="text" name="name" /></td>
		</tr>
		<tr>
			<td align="right">�۸�</td>
			<td><input type="text" name="price" /></td>
		</tr>
		<tr>
			<td align="right">������</td>
			<td><input type="text" name="count" /></td>
		</tr>
		<tr>
			<td align="right">��λ��</td>
			<td><input type="text" name="unit" /></td>
		</tr>
		<tr>
			<td align="right">���أ�</td>
			<td><input type="text" name="add" /></td>
		</tr>
		<tr>
			<td align="center" colspan="2">
				<input type="submit" value="����">
			</td>
		</tr>
	</table>
</form>
</body>
</html>