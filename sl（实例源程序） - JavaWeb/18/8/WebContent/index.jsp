<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:directive.page
	import="org.springframework.context.ApplicationContext" />
<jsp:directive.page
	import="org.springframework.context.support.ClassPathXmlApplicationContext" />
<jsp:directive.page import="java.util.Locale" />	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
</head>
<body>
<%
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    Locale locale = null;
    if (request.getAttribute("language") == null) {
        locale = Locale.CHINA;
    } else {
        locale = (Locale) request.getAttribute("language");
    }
%>
<form action="<%=request.getContextPath()%>/login.do" method="post">
<div id="language" align="left"><a
	href="<%=request.getContextPath()%>/LanguageManager?language=1">简体中文</a> <a
	href="<%=request.getContextPath()%>/LanguageManager?language=3">English</a>
</div>
<table>
	<tr>
		<td><%=context.getMessage("LoginPage.loginName", null, locale)%><input
			type="text" name="name" style="width: 180px" /></td>
	</tr>
	<tr>
		<td><%=context.getMessage("LoginPage.loginPass", null, locale)%>
		&nbsp;<input type="password" name="password" style="width: 180px" /></td>
	</tr>
	<tr>
		<td align="center"><input type="submit" value="<%=context.getMessage("LoginPage.login", null, locale)%>" /> <input
			type="reset" value="<%=context.getMessage("LoginPage.reset", null, locale)%>" /></td>
	</tr>
</table>
</form>
</body>
</html>