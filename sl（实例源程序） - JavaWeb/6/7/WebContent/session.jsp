<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'session.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/style.css">

  </head>
  
  <body>
  <%
  	String name = request.getParameter("name");		//��ȡ�û���д���û���
  	
  	session.setAttribute("name",name);				//���û���������session������
   %>
    <div align="center">
  <form id="form1" name="form1" method="post" action="result.jsp">
    <table width="28%" border="0">
      <tr>
        <td>���������ǣ�</td>
        <td><%=name%></td>
      </tr>
      <tr>
        <td>����ϲ��ȥ�ĵط��ǣ�</td>
        <td><label>
          <input type="text" name="address" />
        </label></td>
      </tr>
      <tr>
        <td colspan="2"><label>
          <div align="center">
            <input type="submit" name="Submit" value="�ύ" />
            </div>
        </label></td>
      </tr>
    </table>
  </form>
  <p>&nbsp;</p>
</div>
  </body>
</html>
