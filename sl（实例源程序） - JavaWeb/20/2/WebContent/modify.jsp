<%--modify.jsp  修改公告信息页面--%>
<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改公告</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    

	<link rel="stylesheet" type="text/css" href="CSS/style.css">
  </head>
  
  <body><form name="form1" method="post" action="PlacardServlet?action=modify">
  <table width="500" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td width="61">&nbsp;</td>
      <td width="397">&nbsp;</td>
      <td width="42">&nbsp;</td>
    </tr>
	<c:set var="form" value="${placardContent}"/>	
    <tr>
      <td height="30" align="center" bgcolor="#FFFFFF">标题：</td>
      <td colspan="2" bgcolor="#FFFFFF"><input name="title" type="text" id="title" value="${form.title}" size="52">
      <input name="id" type="hidden" id="id" value="${form.id}"></td>
    </tr>

    <tr>
      <td height="27" align="center" bgcolor="#FFFFFF">内容：</td>
      <td colspan="2" bgcolor="#FFFFFF"><textarea name="content" cols="50" rows="8" id="content">${form.content}</textarea></td>
    </tr>
    <tr>
      <td height="27" align="center" bgcolor="#FFFFFF">&nbsp;</td>
      <td height="30" colspan="2" align="center" bgcolor="#FFFFFF">
        <input name="Submit" type="submit" class="btn_grey" value="保存">
      &nbsp;
      <input name="Submit2" type="reset" class="btn_grey" value="重置">
&nbsp;
<input name="Submit3" type="button" class="btn_grey" value="返回" onClick="history.back(-1)"></td>
    </tr>
  </table>
  </form>
  </body>
</html>
