<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%
request.setCharacterEncoding("GB18030");
String username=request.getParameter("username");
String pwd=request.getParameter("pwd");
if("mr".equals(username) && "mrsoft".equals(pwd)){
	out.print("<script language='javascript'>alert('µÇÂ¼³É¹¦£¡');window.location.href='index.jsp';</script>");
}else{
	response.sendRedirect("error.jsp");
}
%>
