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
function getNews(){
	var loader=new net.AjaxRequest("getNews.jsp?nocache="+new Date().getTime(),deal_getNews,onerror,"GET");
}
/************************�ص�����**************************************/
function deal_getNews(){
	document.getElementById("showNews").innerHTML=this.req.responseText;
}
window.onload=function(){
	getNews();	//����getNews()������ȡ������Ϣ
	window.setInterval("getNews()", 600000);	//ÿ��10���ӵ���һ��getNews()����
}
</script>

<title>ʵʱ��ʾ������Ϣ</title>
</head>
<body style="font-size:9pt;">
<div id="showNews"></div>
</body>
</html>