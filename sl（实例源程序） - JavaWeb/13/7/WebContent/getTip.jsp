<%@ page contentType="text/html; charset=GBK" language="java" import="java.sql.*" errorPage="" %>
<jsp:useBean id="conn" scope="page" class="com.wgh.core.ConnDB"/>
<%
String id=request.getParameter("id");
String sql="select introduce from tb_book where id="+id;
ResultSet rs=conn.executeQuery(sql);
if(rs.next()){
	out.print(rs.getString(1));
}
%>
