<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>验证身份证号码</title>
	</head>
	<script language="javascript">
function checkeNO(NO){
	var str=NO;
	 //在JavaScript中，正则表达式只能使用"/"开头和结束，不能使用双引号
	var Expression=/^\d{17}[\d|X]$|^\d{15}$/; 
	var objExp=new RegExp(Expression);
	if(objExp.test(str)==true){
		return true;
	}else{
		return false;
	}
}
</script>
	<script language="javascript">
function check(myform){
	if(myform.number.value==""){
		alert("请输入身份证号码!");myform.number.focus();return;
	}
	if(!checkeNO(myform.number.value)){
		alert("您输入的身份证号码不正确!");
		myform.number.focus();
		return;
	}
	if(checkeNO(myform.number.value)){
		alert("您输入的身份证号码正确!");
	}
	myform.submit();
}
</script>
	<body>
	<font style="font-size: 44px">验证身份证号码</font><p>
		<form name="form1" action="" method="post">
			请输入身份证号：
			<input name="number" type="text" id="number"
				onKeyDown="if(event.keyCode==13){form1.number.focus();}">
			<input name="Button" type="button" value="验证"
				onClick="check(form1)">
		</form>
	</body>
</html>

