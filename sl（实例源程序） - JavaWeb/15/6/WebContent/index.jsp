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
    
    <title>�༯�ϵ�����</title>
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
   <h3>�༯�ϵ�����</h3>
<s:append id="a1">
	<s:param value="{'��Java Web����ʵս���䡷', '��JavaWeb ��ѧ�ֲᡷ'}"/>
	<s:param value="{'����̴ʵ䡷', '��ȫ��ʵ¼��'}"/>
	<s:param value="{'��JSP����������ȫ��', '��Java�����ŵ���ͨ��'}"/>
</s:append>

<s:iterator value="#a1" status="status">
	<!-- �жϵ�����Ԫ���Ƿ������һ����������ǣ�����Ӷ��ţ�����ǣ�����Ӿ�� -->
	<s:property/><s:if test="!#status.last">��</s:if><s:else>������ѧϰJavaweb�Ĺ����顣</s:else>
</s:iterator>
  </body>
</html>
