<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'result.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/style.css">

  </head>
  
  <body>
    <div align="center">
  <%
  	
  	String name = (String)session.getAttribute("name");		//获取保存在session范围内的对象
  	
  	String solution = request.getParameter("address");		//获取用户输入的最想去的地方
   %>
<form id="form1" name="form1" method="post" action="">
  <table width="28%" border="0">
    <tr>
      <td colspan="2"><div align="center"><strong>显示答案</strong></div>          </td>
    </tr>
    <tr>
      <td width="49%"><div align="left">您的名字是：</div></td>
      <td width="51%"><label>
        <div align="left"><%=name%></div>		<!-- 将用户输入的用户名在页面中显示 -->
      </label></td>
    </tr>
    <tr>
      <td><label>
        <div align="left">您最喜欢去的地方是：</div>
      </label></td>
      <td><div align="left"><%=solution%></div></td> <!-- 将用户输入的最想去的地方在页面中显示 -->
    </tr>
  </table>
</form>
  <p>&nbsp;</p>
</div>
  </body>
</html>
