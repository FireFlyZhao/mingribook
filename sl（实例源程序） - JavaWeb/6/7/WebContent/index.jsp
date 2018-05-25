<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/style.css">

  </head>
  
  <body>
  <form id="form1" name="form1" method="post" action="session.jsp">
    <div align="center">
  <table width="23%" border="0">
    <tr>
      <td width="36%"><div align="center">您的名字是：</div></td>
      <td width="64%">
        <label>
        <div align="center">
          <input type="text" name="name" />
        </div>
        </label>
        </td>
    </tr>
    <tr>
      <td colspan="2">
        <label>
          <div align="center">
            <input type="submit" name="Submit" value="提交" />
          </div>
        </label>
           </td>
    </tr>
  </table>
</div>
</form>
  </body>
</html>
