<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<html>
<head>
<title>带进度条的文件上传</title>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link href="CSS/style.css" rel="stylesheet">
<script language="javascript" src="JS/AjaxRequest.js"></script>
<script language="javascript">
//此处需要加&nocache="+new Date().getTime()，否则将出现进度不更新的情况
function getProgress(){
	var loader=new net.AjaxRequest("showProgress.jsp?nocache="+new Date().getTime(),deal_p,onerror,"GET");
}
function onerror(){
	alert("上传文件出错！");
}
function deal_p(){
	var h=this.req.responseText;
    h=h.replace(/\s/g,"");	//去除字符串中的Unicode空白符
	document.getElementById("progressPercent").style.display="";	//显示百分比	
	progressPercent.innerHTML=h+"%";		//显示完成的百分比
	document.getElementById("progressBar").style.display="block";	//显示进度条
	document.getElementById("imgProgress").width=h*(255/100);		//显示完成的进度
}
function deal(form){
	form.submit();		//提交表单
	timer=window.setInterval("getProgress()",500);	//每隔500毫秒获取一次上传进度
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
          <td height="34" style="color:#FFFFFF">请选择上传的文件：</td>
        </tr>
        <tr>
          <td height="42"><input name="file" type="file" size="42"></td>
        </tr>
        <tr>
          <td height="50" style="color:#FFFFFF">            注：文件大小请控制在50M以内。</td>
          </tr>
        <tr>
          <td height="29" align="center" style="color:#FFFFFF"><div id="progressBar" class="prog_border" align="left"><img src="images/progressBar.jpg" width="0" height="13" id="imgProgress"></div>
           <span id="progressPercent" style="width:40px;display:none">0%</span></td>
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
