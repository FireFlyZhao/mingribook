<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<script language="javascript" src="JS/AjaxRequest.js"></script>
<script language="javascript">
/******************������ķ���*******************************/
function onerror(){
	alert("���Ĳ�������");
}
/******************ʵ����Ajax����ķ���*******************************/
function getInfo(){
	var loader=new net.AjaxRequest("getInfo.jsp?nocache="+new Date().getTime(),deal_getInfo,onerror,"GET");
}
/************************�ص�����**************************************/
function deal_getInfo(){
	document.getElementById("showInfo").innerHTML=this.req.responseText;
}
window.onload=function(){
	getInfo();	//����getInfo()������ȡ������Ϣ
	window.setInterval("getInfo()", 600000);	//ÿ��10���ӵ���һ��getInfo()����
}
</script>

<title>ʵʱ��ʾ������Ϣ</title>
</head>
<body>
<div style="border: 1px solid;height: 50px; width:200px;padding: 5px;">
	<marquee direction="up" scrollamount="3">
		<div id="showInfo"></div>
	</marquee>
</div>
</body>
</html>