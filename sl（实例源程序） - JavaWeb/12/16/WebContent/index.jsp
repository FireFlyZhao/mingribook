<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>���ݵ�ǰ��������ʾ��ͬ����ʾ��Ϣ</title>
</head>
<body>
<!-- ��ȡ���ڲ����浽������ -->
<c:set var="week">
	<%=new java.util.Date().getDay()%>
</c:set>
<c:choose>
	<c:when test="${week==0 || week==6}">��������Ϣ�գ�����һ������ɣ�</c:when>
	<c:when test="${week==1}" >�µ�һ�ܿ�ʼ�ˣ�Ŭ��ѧϰ�ɣ�</c:when>
	<c:otherwise>����Ŭ��ѧϰ�ɣ�</c:otherwise>
</c:choose>
</body>
</html>