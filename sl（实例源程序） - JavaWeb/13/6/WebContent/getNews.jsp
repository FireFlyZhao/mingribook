<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import="java.sql.*" %>
<jsp:useBean id="conn" class="com.wgh.core.ConnDB" scope="page"></jsp:useBean>
<ul>
<%
ResultSet rs=conn.executeQuery("SELECT content,title FROM tb_news ORDER BY addTime DESC");	//��ȡ������Ϣ
if(rs.next()){
	do{
		out.print("<li title='"+rs.getString(1)+"'>"+rs.getString(2)+"</li>");
	}while(rs.next());
}else{
	out.print("<li>���޹�����Ϣ��</li>");
}
%>

</ul>