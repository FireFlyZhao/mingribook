<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<html>
  <head>
<script language="javascript" src="JS/AjaxRequest.js"></script>
<script language="javascript">
function getSysTime(){
	var loader=new net.AjaxRequest("deal.jsp?nocache="+new Date().getTime(),deal,onerror,"GET");

}
function deal(){
	document.getElementById("clock").innerHTML="现在是："+this.req.responseText;
}
function onerror(){
	alert("出错了");
}
timer = window.setInterval("getSysTime();",1000); 
</script>
  </head>
  
  <body onLoad="getSysTime()" style="margin:0px">
  <table width="901" height="128" border="0" align="center" cellpadding="0" cellspacing="0" background="images/bg.jpg">
    <tr>
      <td height="96">&nbsp;</td>
    </tr>
    <tr>
      <td style="padding-left:20pt;;font-size:9pt;"><div id="clock">系统时间</div></td>
    </tr>
  </table>
    
  </body>
</html>
