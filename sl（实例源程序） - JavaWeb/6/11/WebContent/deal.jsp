<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%
request.setCharacterEncoding("GB18030");
String author=request.getParameter("author");	//��ȡ������
String content=request.getParameter("content");	//��ȡ��������
String message="["+author+"]˵��"+content+"<br>";	//���������Ϣ
if(session.getAttribute("message")!=null){
	message+=session.getAttribute("message").toString();
}
session.setAttribute("message",message);	//��������Ϣ���浽session��
response.sendRedirect("index.jsp");
%>
