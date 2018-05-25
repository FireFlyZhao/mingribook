<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>找回密码第二步</title>
<script language="javascript">
function checkForm(form){
	if(form.answer.value==""){
		alert("请输入密码提示问题答案！");form.answer.focus();return false;
	}
}
</script>
<style>
#forgetPwd2{
	float:left;
	list-style: none;
	padding:50px 0px 0px 200px;
}
#forgetPwd2 li{
	padding:10px;

}
</style>
<body  bgcolor="#F0F0F0">
<div id="box">
<%@ include file="top.jsp" %>
<%@ include file="register.jsp" %>
 <div id="forgetPwd" style="height:356px;">
<form name="form_forgetPwd" method="post" action="UserServlet?action=forgetPwd2" onsubmit="return checkForm(this)">
<ul id="forgetPwd2"><li style="padding-top:5px;">密码提示问题：  <input type="hidden" name="username" value="${requestScope.username}">
	<input type="text" name="question" value="${requestScope.question}" readonly="readonly"></li>
	<li>提示问题答案：
	<input type="text" name="answer" value=""></li>
	 <li style="padding-left:100px;">
	 <input name="Submit" type="submit"  value="下一步">
	</li>
</ul>


</form>
 </div>
 <%@ include file="bottom.jsp" %>
</div>
</body>
</html>