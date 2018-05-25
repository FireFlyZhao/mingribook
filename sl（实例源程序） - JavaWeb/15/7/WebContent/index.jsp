<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>声明资源的国际化</title>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
<h3>使用i18n标签将ApplicationResources资源包压入值栈，使用嵌套的text标签获取本地化消息</h3>
<s:i18n name="ApplicationResources">
	用户名：<s:text name="username"/><br>
	性别：<s:text name="sex"/>
</s:i18n>

<h3>直接使用text标签，从资源包基名与Action类名相同的资源包中获取本地化消息</h3>
用户名：<s:text name="username"/><br>
性别：<s:text name="sex"/><br>
日期：
<%
	pageContext.setAttribute("now", new java.util.Date());
%>
<!-- 使用嵌套的param标签为消息文本中的参数设值，第一个param标签为{0)参数设值，第二个param标签为{1}参数设值 -->
<s:text name="now">
	<s:param value="#attr.now"/>
	<s:param value="'mrsoft'"/>
</s:text>
  </body>
</html>
