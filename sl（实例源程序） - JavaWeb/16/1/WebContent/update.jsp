<%@page import="com.mr.employee.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%Employee employeeVO=(Employee)request.getAttribute("employeeVO");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function btnClick(){
	window.location.href="<%=request.getContextPath()%>/QueryEmployee";
}
</script>
</head>
<body>
<form action="<%=request.getContextPath()%>/UpdateEmployee" method="post">
编号<input type="text" name="id" value="<%=employeeVO.getId()%>"/><br/>
名称<input type="text" name="name" value="<%=employeeVO.getName()%>"/><br/>
性别<input type="text" name="sex" value="<%=employeeVO.getSex()%>"/><br/>
职位<input type="text" name="business" value="<%=employeeVO.getBusiness()%>"/><br/>
地址<input type="text" name="address" value="<%=employeeVO.getAddress()%>"/><br/>
备注<input type="text" name="remark" value="<%=employeeVO.getRemark()%>"/><br/>
<input type="submit" value="提交"/>
<input type="button" value="取消" onclick="btnClick()"/>
</form>
</body>
</html>