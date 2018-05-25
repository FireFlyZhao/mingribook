<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>用户注册</title>
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
    <td width="76" align="center">用&nbsp;户&nbsp;名：</td>
    <td width="324">
      <input name="user" type="text" id="user">    </td>
  </tr>
  <tr>
    <td align="center">密&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
    <td><input name="pwd" type="password" id="pwd"></td>
  </tr>
  <tr>
    <td align="center">确认密码：</td>
    <td><input name="pwd1" type="password" id="pwd1"></td>
  </tr>
  <tr>
    <td align="center">E-mail：</td>
    <td><input name="email" type="text" id="email" size="45"></td>
  </tr>
  <tr>
    <td align="center">性&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
    <td><input name="sex" type="radio" value="男" checked="checked">
      男 
      <input name="sex" type="radio" value="女">
      女</td>
  </tr>
  <tr>
    <td align="center">爱 &nbsp;&nbsp;&nbsp;&nbsp;好：</td>
    <td><input name="affect" type="checkbox" id="affect" value="游泳">
      游泳
      <input name="affect" type="checkbox" id="affect" value="旅游">
      旅游
      <input name="affect" type="checkbox" id="affect" value="看书">
      看书
      <input name="affect" type="checkbox" id="affect" value="唱歌">
      唱歌</td>
  </tr>
  <tr>
    <td align="center">备&nbsp;&nbsp;&nbsp;&nbsp;注：</td>
    <td><textarea name="memo" cols="43" rows="5" id="memo"></textarea></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td><input type="submit" name="Submit" value="注册">
      <input type="reset" name="Submit2" value="重置"></td>
  </tr>
</table>
</form>
</body>
</html>