<%@ page contentType="text/html; charset=UTF-8" language="java" errorPage="" %>
<%
         session.invalidate();
 out.println("<script>parent.location.href='index.jsp';</script>");
%>

