<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>�û�ע�ᡪ��Э��</title>
<style>
td,body{
font-size:12px;
padding:5px;
}
</style>
</head>
<body>
<table width="400" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td>��ȷ�����Э�飺</td>
  </tr>
  <tr>
    <td height="159" align="center" valign="top"><textarea name="agreement" cols="60" rows="10" id="agreement">
    <c:import url="agreement.txt" charEncoding="GBK"/>
    </textarea></td>
  </tr>
  <tr>
    <td align="center"><input type="submit" name="Submit" value="�ҽ�������Э��"></td>
  </tr>
</table>
</body>
</html>