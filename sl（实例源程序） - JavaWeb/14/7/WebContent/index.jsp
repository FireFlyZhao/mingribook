<%@ page language="java" contentType="text/html; charset=GBK"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>����������ע����Ϣ</title>
</head>
<body>
<H1>����������ע����Ϣ</H1> 
<s:form action="regist">
    <s:textfield label="�û���" name="name"/>
    <s:password label="����" name="pass"/>
    <s:password label="ȷ������" name="rpass"/>
    <s:textfield label="����" name="age"/>
    <s:textfield label="�绰" name="phone"/>
    <s:submit value="�ύ"/> 
</s:form> 
</body>
</html> 
  