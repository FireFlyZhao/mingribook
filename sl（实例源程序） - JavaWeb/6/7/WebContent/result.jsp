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
  	
  	String name = (String)session.getAttribute("name");		//��ȡ������session��Χ�ڵĶ���
  	
  	String solution = request.getParameter("address");		//��ȡ�û����������ȥ�ĵط�
   %>
<form id="form1" name="form1" method="post" action="">
  <table width="28%" border="0">
    <tr>
      <td colspan="2"><div align="center"><strong>��ʾ��</strong></div>          </td>
    </tr>
    <tr>
      <td width="49%"><div align="left">���������ǣ�</div></td>
      <td width="51%"><label>
        <div align="left"><%=name%></div>		<!-- ���û�������û�����ҳ������ʾ -->
      </label></td>
    </tr>
    <tr>
      <td><label>
        <div align="left">����ϲ��ȥ�ĵط��ǣ�</div>
      </label></td>
      <td><div align="left"><%=solution%></div></td> <!-- ���û����������ȥ�ĵط���ҳ������ʾ -->
    </tr>
  </table>
</form>
  <p>&nbsp;</p>
</div>
  </body>
</html>
