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
    
    <title>多集合的连接</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
   <h3>多集合的连接</h3>
<s:append id="a1">
	<s:param value="{'《Java Web开发实战宝典》', '《JavaWeb 自学手册》'}"/>
	<s:param value="{'《编程词典》', '《全程实录》'}"/>
	<s:param value="{'《JSP开发技术大全》', '《Java从入门到精通》'}"/>
</s:append>

<s:iterator value="#a1" status="status">
	<!-- 判断迭代的元素是否是最后一个，如果不是，则添加逗号，如果是，则添加句号 -->
	<s:property/><s:if test="!#status.last">，</s:if><s:else>，都是学习Javaweb的工具书。</s:else>
</s:iterator>
  </body>
</html>
