<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%
request.setCharacterEncoding("GB18030");
String author=request.getParameter("author");	//获取留言人
String content=request.getParameter("content");	//获取留言内容
String message="["+author+"]说："+content+"<br>";	//组合留言信息
if(session.getAttribute("message")!=null){
	message+=session.getAttribute("message").toString();
}
session.setAttribute("message",message);	//将留言信息保存到session中
response.sendRedirect("index.jsp");
%>
