<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>使用监听查看在线用户</title>
</head>
<script language="javascript">
function checkEmpty(form){
for(i=0;i<form.length;i++){
if(form.elements[i].value==""){
alert("表单信息不能为空");
return false;
}
}
}
</script>
<link href="css/style.css" rel="stylesheet" type="text/css">
<body>
<div align="center">
  <table width="506" height="170" border="0" cellpadding="0" cellspacing="0" background="image/background1.jpg">
    <tr>
      <td align="center">
	    <form name="form" method="post" action="showUser.jsp" onSubmit="return checkEmpty(form)">
    <input type="text" name="user"><br><br>
    <input type="submit" name="Submit" value="登录">
  </form>
	  
	  
	  
	  </td>
    </tr>
  </table>
</div>
</body>
</html>
