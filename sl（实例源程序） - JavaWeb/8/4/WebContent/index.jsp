<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>�û�ע��</title>
</head>
<body>

<form action="RegServlet" method="post">
	<table align="center" width="450">
		<tr>
			<td align="center" colspan="2">
				<h2>�û�ע��</h2>
				<hr>
			</td>
		</tr>
		<tr>
			<td align="right">�û�����</td>
			<td><input type="text" name="name" /></td>
		</tr>
		<tr>
			<td align="right">���룺</td>
			<td><input type="password" name="password" /></td>
		</tr>
		<tr>
			<td align="right">�Ա�</td>
			<td>
				<input type="radio" name="sex" value="��" checked="checked">��
				<input type="radio" name="sex" value="Ů">Ů
			</td>
		</tr>
		<tr>
			<td align="right">QQ���룺</td>
			<td><input type="text" name="qq" /></td>
		</tr>
		<tr>
			<td align="right">E-Mail��ַ��</td>
			<td><input type="text" name="mail" /></td>
		</tr>
		<tr>
			<td align="center" colspan="2">
				<input type="submit" value="ע����">
			</td>
		</tr>
	</table>
</form>
</body>
</html>