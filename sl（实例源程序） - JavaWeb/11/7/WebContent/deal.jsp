<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%
request.setCharacterEncoding("GB18030");
%>
${empty param.username?"用户名为空":param.username}
<br>
${empty param.pwd?"密码为空":param.pwd}
<br>
<a href="index.jsp">返回</a>