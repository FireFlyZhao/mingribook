<%@ page language="java" contentType="text/html; charset=GBK"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
        <title>ת���ɹ�</title>
        <style type="text/css">
<!--
.STYLE1 {
	font-size: 16px;
	font-weight: bold;
}
-->
        </style>
</head>
<body>
 <p align="center" class="STYLE1">&nbsp;</p>
 <p align="center" class="STYLE1">&nbsp;</p>
 <p align="center" class="STYLE1">ת���ɹ���</p>
 <div align="center">
   <table width="211" border="1">
     <tr>
       <td width="116" bgcolor="#FFCCFF"><div align="center">�û�����</div></td>
       <td width="79"><s:property value="name"/></td>
     </tr>
     <tr>
       <td bgcolor="#FFCCFF"><div align="center">��&nbsp;&nbsp;&nbsp;&nbsp;�룺</div></td>
       <td><s:property value="password"/></td>
     </tr>
     <tr>
       <td bgcolor="#FFCCFF"><div align="center">�������ڣ�</div></td>
       <td><s:property value="user.date"/></td>
     </tr>
   </table>
 </div>
</body>
</html>