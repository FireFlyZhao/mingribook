<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>�û�ע��</title>
<style>
td,body{
padding:5px;
font-size:12px;
}
</style>
</head>
<body>
<form name="form1" method="post" action="deal.jsp">
<table width="400" height="30" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="76" align="center">��&nbsp;��&nbsp;����</td>
    <td width="324">
      <input name="user" type="text" id="user">    </td>
  </tr>
  <tr>
    <td align="center">��&nbsp;&nbsp;&nbsp;&nbsp;�룺</td>
    <td><input name="pwd" type="password" id="pwd"></td>
  </tr>
  <tr>
    <td align="center">ȷ�����룺</td>
    <td><input name="pwd1" type="password" id="pwd1"></td>
  </tr>
  <tr>
    <td align="center">E-mail��</td>
    <td><input name="email" type="text" id="email" size="45"></td>
  </tr>
  <tr>
    <td align="center">��&nbsp;&nbsp;&nbsp;&nbsp;��</td>
    <td><input name="sex" type="radio" value="��" checked="checked">
      �� 
      <input name="sex" type="radio" value="Ů">
      Ů</td>
  </tr>
  <tr>
    <td align="center">�� &nbsp;&nbsp;&nbsp;&nbsp;�ã�</td>
    <td><input name="affect" type="checkbox" id="affect" value="��Ӿ">
      ��Ӿ
      <input name="affect" type="checkbox" id="affect" value="����">
      ����
      <input name="affect" type="checkbox" id="affect" value="����">
      ����
      <input name="affect" type="checkbox" id="affect" value="����">
      ����</td>
  </tr>
  <tr>
    <td align="center">��&nbsp;&nbsp;&nbsp;&nbsp;ע��</td>
    <td><textarea name="memo" cols="43" rows="5" id="memo"></textarea></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td><input type="submit" name="Submit" value="ע��">
      <input type="reset" name="Submit2" value="����"></td>
  </tr>
</table>
</form>
</body>
</html>