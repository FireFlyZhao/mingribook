<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <title>�򻯵�����ת����</title>
    <base href="<%=basePath%>">
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script language="javascript">
	function check()
	{ 
	    var a=/^(\d{1,4})(-|v)(\d{1,2})\2(\d{1,2})/;
	    if(!a.test(document.form1.user.value))
	    {
	     alert("���ڸ�ʽ����ȷ��");
	     return false;
	    }
	   else
	   { 
	     return true;
	   }
	}
	</script></head>
  <body> 
    <form action="login.action" method="post" name="form1">
    <table width="319" border="1" align="center">
    <caption>
    <h3><br>
      <br>
    �û�ע��</h3>
    </caption>
        <tr align="center">
            <td width="105" height="26" bgcolor="#FFCCFF"><div align="center">�û�����</div></td>
            <td width="198" bgcolor="#FFCCFF"><label>
              <div align="left">
                <input type="text" name="name">
              </div>
            </label></td>
        </tr>
        <tr>
          <td height="26" bgcolor="#FFCCFF"><div align="center">��&nbsp;&nbsp;�룺</div></td>
          <td height="26" bgcolor="#FFCCFF"><label>
            <input type="password" name="password">
          </label></td>
        </tr>
        <tr> 
            <td height="26" bgcolor="#FFCCFF"><div align="center">�������ڣ�</div></td>
            <td height="26" bgcolor="#FFCCFF"><input type="text" name="user"/></td>
        </tr> 
        <tr align="center">
            <td colspan="2" bgcolor="#FFCCFF"><input type="submit" value="ע��" onclick="return check();"/>
              &nbsp;
              <input type="reset" value="����"/></td>
        </tr>
    </table>
</form>
  </body>
</html>
