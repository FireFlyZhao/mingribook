<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>��֤���֤����</title>
	</head>
	<script language="javascript">
function checkeNO(NO){
	var str=NO;
	 //��JavaScript�У�������ʽֻ��ʹ��"/"��ͷ�ͽ���������ʹ��˫����
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
		alert("���������֤����!");myform.number.focus();return;
	}
	if(!checkeNO(myform.number.value)){
		alert("����������֤���벻��ȷ!");
		myform.number.focus();
		return;
	}
	if(checkeNO(myform.number.value)){
		alert("����������֤������ȷ!");
	}
	myform.submit();
}
</script>
	<body>
	<font style="font-size: 44px">��֤���֤����</font><p>
		<form name="form1" action="" method="post">
			���������֤�ţ�
			<input name="number" type="text" id="number"
				onKeyDown="if(event.keyCode==13){form1.number.focus();}">
			<input name="Button" type="button" value="��֤"
				onClick="check(form1)">
		</form>
	</body>
</html>

