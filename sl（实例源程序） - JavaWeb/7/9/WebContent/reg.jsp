<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>ע����Ϣ</title>
</head>
<body>
<%request.setCharacterEncoding("GB18030"); %>
<jsp:useBean id="user" class="com.lyq.bean.User">
	<jsp:setProperty property="*" name="user"/>
</jsp:useBean>
<table align="center" width="400">
	<tr>
		<td align="right">�ա�����</td>
		<td>
			<jsp:getProperty property="name" name="user"/>
		</td>
	</tr>
	<tr>
		<td align="right">�ܡ��룺</td>
		<td>
			<jsp:getProperty property="password" name="user"/>
		</td>
	</tr>
	<tr>
		<td align="right">�ԡ���</td>
		<td>
			<jsp:getProperty property="sex" name="user"/>
		</td>
	</tr>
	<tr>
		<td align="right">QQ���룺</td>
		<td>
			<jsp:getProperty property="qq" name="user"/>
		</td>
	</tr>
	<tr>
		<td align="right">E-Mail��ַ��</td>
		<td>
			<jsp:getProperty property="mail" name="user"/>
		</td>
	</tr>
</table>
</body>
</html>