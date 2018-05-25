<%@ page contentType="text/html; charset=GBK" language="java" import="java.text.*" errorPage="" %>
<%
String datestyle="yyyy-MM-dd HH:mm:ss";
SimpleDateFormat format=new SimpleDateFormat(datestyle);
java.util.Date nowtime=new java.util.Date();
String strnowtime=format.format(nowtime);
out.println(strnowtime);
%>