<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import="java.sql.*" %>
<jsp:useBean id="conn" class="com.wgh.core.ConnDB" scope="page"></jsp:useBean>
<ul>
<%
ResultSet rs=conn.executeQuery("SELECT title FROM tb_bbsInfo ORDER BY id DESC");	//��ȡ������Ϣ
if(rs.next()){
	do{
		out.print("<li>"+rs.getString(1)+"</li>");
	}while(rs.next());
}else{
	out.print("<li>���޹�����Ϣ��</li>");
}
%>

</ul>