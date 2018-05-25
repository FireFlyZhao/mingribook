<%--index.jsp  添加公告信息页面--%>
<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>保存公告信息到XML文件</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<link rel="stylesheet" type="text/css" href="CSS/style.css">
	<script language="javascript">
		function check(form){
			if(form.title.value==""){
				alert("请输入公告标题！");form.title.focus();return false;
			}
			if(form.content.value==""){
				alert("请输入公告内容！");form.content.focus();return false;
			}
		}
	</script>
  </head>
  
  <body>
<form name="form1" method="post" action="PlacardServlet" target="_blank" onSubmit="return check(this)">
  <table width="500" height="271" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
    <tr>
      <td width="90" height="23">&nbsp;</td>
      <td width="410">&nbsp;</td>
    </tr>
    <tr>
      <td colspan="2" align="center">·添加公告信息</td>
    </tr>
    <tr>
      <td height="28" align="center">公告标题：</td>
      <td><input name="title" type="text" id="title" size="52"></td>
    </tr>
    <tr>
      <td height="157" align="center">公告内容：</td>
      <td><textarea name="content" cols="50" rows="9" id="content"></textarea></td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td><input name="Submit" type="submit" class="btn_grey" value="保存">
      &nbsp;
      <input name="Submit2" type="reset" class="btn_grey" value="重置"></td>
    </tr>
  </table>
</form>  
  </body>
</html>
