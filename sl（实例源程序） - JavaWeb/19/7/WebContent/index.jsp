<%@ page language="java" pageEncoding="GB2312"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<title>�û���Ϣע��</title>
			<script language="javascript">
   function isEmpty()
    {
	var l1=document.f.username.value;
	if( l1.length == 0 || l1 == null)
		{alert("�û�������Ϊ��");return;}
			var l2=document.f.password.value;
	if( l2.length == 0 || l2 == null)
		{alert("���벻��Ϊ��");return;}
			var l3=document.f.realname.value;
	if( l3.length == 0 || l3 == null)
		{alert("��������Ϊ��");return;}
			
	var fieldvalue = document.f.age.value;
	if( fieldvalue.length == 0 || fieldvalue == null)
		{alert("���䲻��Ϊ��");return;}
	var charcode;
	var mxx="0123456789";
	for(var i=0; i<fieldvalue.length; i++){
		charcode = fieldvalue.charAt(i);
		if( (mxx.indexOf(charcode)) < 0 )
		var x=0
	}
	if (x==0){
	{alert("����ֻ��������");return;}
	}	
   	var field = document.f.tel.value;
	if( field.length == 0 || field == null)
		alert("�绰����Ϊ��");
	var charcode;
	var mxx="0123456789";
	for(var i=0; i<field.length; i++){
		charcode = field.charAt(i);
		if( (mxx.indexOf(charcode)) < 0 )
		var y=0;
	}
	if (y==0){
	alert("�绰ֻ��������");
	}	
}
</script>
	</head>

	<body>
		<form action="commit.do" method="POST" name="f">
			<table width="750" height="466"  border="0" cellpadding="0" cellspacing="0" background="picture/usermodifi.jpg">
              <tr>
                <td height="50" colspan="8">&nbsp;</td>
              </tr>
              <tr>
                <td width="43" height="22">&nbsp;</td>
                <td colspan="2"><div align="center"></div></td>
                <td colspan="2"><div align="center"></div></td>
                <td height="22" colspan="3">&nbsp;</td>
              </tr>
              <tr>
                <td height="31" colspan="8">&nbsp;</td>
              </tr>
              <tr>
                <td height="28">&nbsp;</td>
                <td height="28">&nbsp;</td>
                <td height="28" colspan="5"><div align="center">�û���Ϣע�� </div></td>
                <td height="28">&nbsp;</td>
              </tr>
              <tr>
                <td height="31">&nbsp;</td>
                <td width="52" height="31">&nbsp;</td>
                <td height="31" colspan="2"><div align="center">�û����� </div></td>
                <td colspan="3"><input id="username" type="text" name="username"></td>
                <td width="260">&nbsp;</td>
              </tr>
              <tr>
                <td height="29">&nbsp;</td>
                <td height="29">&nbsp;</td>
                <td height="29" colspan="2"><div align="center">���룺 </div></td>
                <td height="29" colspan="3"><input id="password" type="password" name="password"></td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td height="32">&nbsp;</td>
                <td height="32">&nbsp;</td>
                <td height="32" colspan="2"><div align="center">������ </div></td>
                <td height="32" colspan="3"><input id="realname" type="text" name="realname"></td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td height="35">&nbsp;</td>
                <td height="35">&nbsp;</td>
                <td height="35" colspan="2"><div align="center">���䣺 </div></td>
                <td height="35" colspan="3"><input id="age" type="text" name="age"></td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td height="25">&nbsp;</td>
                <td height="25">&nbsp;</td>
                <td height="25" colspan="2"><div align="center">�绰��</div></td>
                <td height="25" colspan="3"><input id="tel" type="text" name="tel"></td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td height="36">&nbsp;</td>
                <td height="36">&nbsp;</td>
                <td height="36" colspan="2"><div align="center"></div></td>
                <td width="49" height="36">&nbsp;</td>
                <td width="105"><div align="right">
                  <input type="submit" name="Submit2" value="ע��" onMouseUp="isEmpty()">
                  <input type="reset" name="Submit" value="����">
                </div></td>
                <td width="126">&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td height="145" colspan="8"><font color="red">${msg}</font></td>
              </tr>
          </table>
			<div align="center"></div>
		</form>
	</body>
</html>
