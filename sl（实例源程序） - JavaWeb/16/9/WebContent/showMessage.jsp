<%@ page language="java" import="java.util.*,com.wgh.model.TbMessage" pageEncoding="GBK"%>
<%TbMessage tbMessage = (TbMessage)request.getAttribute("tbMessage"); %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script language="javascript">
function check(){
	if(form1.writer.value==""){
		alert("留言人不能为空！");form1.writer.focus();return false;
	}
	if(form1.content.value==""){
		alert("留言内容不能为空！");form1.content.focus();return false;
	}
	return true;
}
</script>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改留言</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="CSS/style.css">
  </head>
  
  <body>
  <table width="797" height="234" border="0" align="center" cellpadding="0" cellspacing="0" background="images/top.jpg">
    <tr>
      <td>&nbsp;</td>
    </tr>
  </table>
  <form name="form1" method="post" action="MessageServlet?action=update" onSubmit="return check();">
  <table width="797" height="340" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td width="210" height="368" rowspan="2" background="images/left.jpg">&nbsp;</td>
      <td height="290" align="center" valign="top"><table width="95%" height="286" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td width="14%"><strong>留言人：</strong></td>
          <td width="86%">
            <input name="writer" type="text" id="writer" value="<%=tbMessage.getWriter() %>"> 
            *          
            <input name="id" type="hidden" id="id" value="<%=tbMessage.getId()%>"></td>
        </tr>
        <tr>
          <td height="191"><strong>留言内容：</strong></td>
          <td><textarea name="content" cols="70" rows="9" class="wenbenkuang" id="content"><%=tbMessage.getContent() %></textarea> 
            * </td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td><input name="Submit" type="submit" class="btn_bg" value="提 交">
            &nbsp;&nbsp;
            <input name="Submit2" type="reset" class="btn_bg" value="重  置">
            &nbsp;&nbsp;
            <input name="Submit3" type="button" class="btn_bg" value="返  回" onClick="window.location.href='MessageServlet?action=list';"></td>
        </tr>
      </table></td>
      <td width="25" rowspan="2" background="images/right.jpg">&nbsp;</td>
    </tr>
    <tr>
      <td height="78" background="images/bottom.jpg">&nbsp;</td>
    </tr>
  </table>
  </form>
  </body>
</html>
