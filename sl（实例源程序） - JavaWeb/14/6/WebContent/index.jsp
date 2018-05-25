<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <title>简化的类型转换器</title>
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
	     alert("日期格式不正确！");
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
    用户注册</h3>
    </caption>
        <tr align="center">
            <td width="105" height="26" bgcolor="#FFCCFF"><div align="center">用户名：</div></td>
            <td width="198" bgcolor="#FFCCFF"><label>
              <div align="left">
                <input type="text" name="name">
              </div>
            </label></td>
        </tr>
        <tr>
          <td height="26" bgcolor="#FFCCFF"><div align="center">密&nbsp;&nbsp;码：</div></td>
          <td height="26" bgcolor="#FFCCFF"><label>
            <input type="password" name="password">
          </label></td>
        </tr>
        <tr> 
            <td height="26" bgcolor="#FFCCFF"><div align="center">出生日期：</div></td>
            <td height="26" bgcolor="#FFCCFF"><input type="text" name="user"/></td>
        </tr> 
        <tr align="center">
            <td colspan="2" bgcolor="#FFCCFF"><input type="submit" value="注册" onclick="return check();"/>
              &nbsp;
              <input type="reset" value="重置"/></td>
        </tr>
    </table>
</form>
  </body>
</html>
