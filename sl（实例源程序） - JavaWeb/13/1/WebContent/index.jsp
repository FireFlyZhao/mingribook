<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>����û����Ƿ�Ψһ</title>
<script language="javascript">
function createRequest(url) {
    http_request = false;
    if (window.XMLHttpRequest) {    							   // ��IE�����
        http_request = new XMLHttpRequest();	                      //����XMLHttpRequest����
    } else if (window.ActiveXObject) {     						   // IE�����
        try {
            http_request = new ActiveXObject("Msxml2.XMLHTTP");	   //����XMLHttpRequest����
        } catch (e) {
            try {
                http_request = new ActiveXObject("Microsoft.XMLHTTP");  //����XMLHttpRequest����
           } catch (e) {}
        }
    }
    if (!http_request) {
        alert("���ܴ���XMLHttpRequest����ʵ����");
        return false;
    }
    http_request.onreadystatechange = getResult;					   //���÷��ؽ��������
    http_request.open('GET', url, true);							   //�����������������
    http_request.send(null);									   //���������������
}
function getResult() {
    if (http_request.readyState == 4) {     		// �ж�����״̬
        if (http_request.status == 200) {     		// ����ɹ�����ʼ�����ؽ��
            document.getElementById("toolTip").innerHTML=http_request.responseText;	//������ʾ����
            document.getElementById("toolTip").style.display="block";	//��ʾ��ʾ��
        } else {     						// ����ҳ���д���
            alert("���������ҳ���д���");
        }
    }
}
function checkUser(userName){
	if(userName.value==""){
		alert("�������û�����");userName.focus();return;
	}else{
		createRequest('checkUser.jsp?user='+userName.value);
	}
}

</script>
<style type="text/css">
<!--
#toolTip {
	position:absolute;
	left:331px;
	top:39px;
	width:98px;
	height:48px;
	padding-top:45px;
	padding-left:25px;
	padding-right:25px;
	z-index:1;
	display:none;
	color:red;
	background-image: url(images/tooltip.jpg);
}
-->
</style>
</head>
<body style="margin: 0px;">
<form method="post" action="" name="form1">

<table width="509" height="352" border="0" align="center" cellpadding="0" cellspacing="0" background="images/bg.gif">
  <tr>
    <td height="54">&nbsp;</td>
  </tr>
  <tr>
    <td height="253" valign="top">
	<div style="position:absolute;">

	
    <table width="100%" height="250" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td width="18%" height="54" align="right" style="color:#8e6723 "><b>�û�����</b></td>
        <td width="49%"><input name="username" type="text" id="username" size="32"></td>
        <td width="33%"><img src="images/checkBt.jpg" width="104" height="23" style="cursor:hand;" onClick="checkUser(form1.username);"></td>
      </tr>
      <tr>
        <td height="51" align="right" style="color:#8e6723 "><b>���룺</b></td>
        <td><input name="pwd1" type="password" id="pwd1" size="35"></td>
        <td rowspan="2">&nbsp;    <div id="toolTip"></div></td>
      </tr>
      <tr>
        <td height="56" align="right" style="color:#8e6723 "><b>ȷ�����룺</b></td>
        <td><input name="pwd2" type="password" id="pwd2" size="35"></td>
        </tr>
      <tr>
        <td height="55" align="right" style="color:#8e6723 "><b>E-mail��</b></td>
        <td colspan="2"><input name="email" type="text" id="email" size="45"></td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td colspan="2"><input type="image" name="imageField" src="images/registerBt.jpg"></td>
      </tr>
    </table>
	</div>
	</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
  </tr>
</table>

</form>

</body>
</html>