<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	name参数的值为：<%=new String(request.getParameter("name").getBytes("iso-8859-1"),"UTF-8") %><br>
sex参数的值为：<%=request.getParameter("sex") %>
	
</body>
</html>