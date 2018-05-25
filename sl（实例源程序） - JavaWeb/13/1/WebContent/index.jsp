<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>检测用户名是否唯一</title>
<script language="javascript">
function createRequest(url) {
    http_request = false;
    if (window.XMLHttpRequest) {    							   // 非IE浏览器
        http_request = new XMLHttpRequest();	                      //创建XMLHttpRequest对象
    } else if (window.ActiveXObject) {     						   // IE浏览器
        try {
            http_request = new ActiveXObject("Msxml2.XMLHTTP");	   //创建XMLHttpRequest对象
        } catch (e) {
            try {
                http_request = new ActiveXObject("Microsoft.XMLHTTP");  //创建XMLHttpRequest对象
           } catch (e) {}
        }
    }
    if (!http_request) {
        alert("不能创建XMLHttpRequest对象实例！");
        return false;
    }
    http_request.onreadystatechange = getResult;					   //调用返回结果处理函数
    http_request.open('GET', url, true);							   //创建与服务器的连接
    http_request.send(null);									   //向服务器发送请求
}
function getResult() {
    if (http_request.readyState == 4) {     		// 判断请求状态
        if (http_request.status == 200) {     		// 请求成功，开始处理返回结果
            document.getElementById("toolTip").innerHTML=http_request.responseText;	//设置提示内容
            document.getElementById("toolTip").style.display="block";	//显示提示框
        } else {     						// 请求页面有错误
            alert("您所请求的页面有错误！");
        }
    }
}
function checkUser(userName){
	if(userName.value==""){
		alert("请输入用户名！");userName.focus();return;
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
        <td width="18%" height="54" align="right" style="color:#8e6723 "><b>用户名：</b></td>
        <td width="49%"><input name="username" type="text" id="username" size="32"></td>
        <td width="33%"><img src="images/checkBt.jpg" width="104" height="23" style="cursor:hand;" onClick="checkUser(form1.username);"></td>
      </tr>
      <tr>
        <td height="51" align="right" style="color:#8e6723 "><b>密码：</b></td>
        <td><input name="pwd1" type="password" id="pwd1" size="35"></td>
        <td rowspan="2">&nbsp;    <div id="toolTip"></div></td>
      </tr>
      <tr>
        <td height="56" align="right" style="color:#8e6723 "><b>确认密码：</b></td>
        <td><input name="pwd2" type="password" id="pwd2" size="35"></td>
        </tr>
      <tr>
        <td height="55" align="right" style="color:#8e6723 "><b>E-mail：</b></td>
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