<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<html>
<head>
<title>�����������ļ��ϴ�</title>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link href="CSS/style.css" rel="stylesheet">
<script language="javascript" src="JS/AjaxRequest.js"></script>
<script language="javascript">
//�˴���Ҫ��&nocache="+new Date().getTime()�����򽫳��ֽ��Ȳ����µ����
function getProgress(){
	var loader=new net.AjaxRequest("showProgress.jsp?nocache="+new Date().getTime(),deal_p,onerror,"GET");
}
function onerror(){
	alert("�ϴ��ļ�����");
}
function deal_p(){
	var h=this.req.responseText;
    h=h.replace(/\s/g,"");	//ȥ���ַ����е�Unicode�հ׷�
	document.getElementById("progressPercent").style.display="";	//��ʾ�ٷֱ�	
	progressPercent.innerHTML=h+"%";		//��ʾ��ɵİٷֱ�
	document.getElementById("progressBar").style.display="block";	//��ʾ������
	document.getElementById("imgProgress").width=h*(255/100);		//��ʾ��ɵĽ���
}
function deal(form){
	form.submit();		//�ύ��
	timer=window.setInterval("getProgress()",500);	//ÿ��500�����ȡһ���ϴ�����
}
</script>
</head>
<body>
<form name="form1" enctype="multipart/form-data" method="post" action="UpLoad?action=uploadFile">
  <table width="500" height="289" border="0" align="center" cellpadding="0" cellspacing="0" background="images/bg.jpg">
    <tr>
      <td width="61" rowspan="2">&nbsp;</td>
      <td width="439" align="center">
<table width="80%" height="190"  border="0" cellpadding="0" cellspacing="0">
    <tr>
      <td align="center">&nbsp;</td>
    </tr>
        <tr>
          <td height="34" style="color:#FFFFFF">��ѡ���ϴ����ļ���</td>
        </tr>
        <tr>
          <td height="42"><input name="file" type="file" size="42"></td>
        </tr>
        <tr>
          <td height="50" style="color:#FFFFFF">            ע���ļ���С�������50M���ڡ�</td>
          </tr>
        <tr>
          <td height="29" align="center" style="color:#FFFFFF"><div id="progressBar" class="prog_border" align="left"><img src="images/progressBar.jpg" width="0" height="13" id="imgProgress"></div>
          �0�2<span id="progressPercent" style="width:40px;display:none">0%</span></td>
        </tr>
        <tr>
          <td height="29" align="center"><img src="images/shangchuan.gif" width="61" height="23" onClick="deal(form1)">
            <img src="images/chongzhi.gif" width="61" height="23" onClick="form1.reset();">&nbsp;
  		  </td></tr>
      </table>	  </td>
    </tr>

  </table>
</form>
</body>
</html>
