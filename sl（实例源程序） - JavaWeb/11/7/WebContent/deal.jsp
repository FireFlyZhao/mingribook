<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%
request.setCharacterEncoding("GB18030");
%>
${empty param.username?"�û���Ϊ��":param.username}
<br>
${empty param.pwd?"����Ϊ��":param.pwd}
<br>
<a href="index.jsp">����</a>