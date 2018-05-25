<%@ page language="java" contentType="text/html; charset=GBK"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>请输入您的注册信息</title>
</head>
<body>
<H1>请输入您的注册信息</H1> 
<s:form action="regist">
    <s:textfield label="用户名" name="name"/>
    <s:password label="密码" name="pass"/>
    <s:password label="确认密码" name="rpass"/>
    <s:textfield label="年龄" name="age"/>
    <s:textfield label="电话" name="phone"/>
    <s:submit value="提交"/> 
</s:form> 
</body>
</html> 
  