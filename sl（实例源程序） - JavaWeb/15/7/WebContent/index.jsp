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
    
    <title>������Դ�Ĺ��ʻ�</title>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
<h3>ʹ��i18n��ǩ��ApplicationResources��Դ��ѹ��ֵջ��ʹ��Ƕ�׵�text��ǩ��ȡ���ػ���Ϣ</h3>
<s:i18n name="ApplicationResources">
	�û�����<s:text name="username"/><br>
	�Ա�<s:text name="sex"/>
</s:i18n>

<h3>ֱ��ʹ��text��ǩ������Դ��������Action������ͬ����Դ���л�ȡ���ػ���Ϣ</h3>
�û�����<s:text name="username"/><br>
�Ա�<s:text name="sex"/><br>
���ڣ�
<%
	pageContext.setAttribute("now", new java.util.Date());
%>
<!-- ʹ��Ƕ�׵�param��ǩΪ��Ϣ�ı��еĲ�����ֵ����һ��param��ǩΪ{0)������ֵ���ڶ���param��ǩΪ{1}������ֵ -->
<s:text name="now">
	<s:param value="#attr.now"/>
	<s:param value="'mrsoft'"/>
</s:text>
  </body>
</html>
