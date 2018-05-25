<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	request.setAttribute("ContextPath", path);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>批量添加信息</title>
</head>
<body>
<div id="main">
<form action="${ContextPath}/save.do" method="post">
<br />
<table>
	<tr>
		<td width="120px" class="td_pad">用户名称：</td>
		<td><input type="text" name="name" value="" /></td>
	</tr>
	<tr>
		<td width="120px" class="td_pad">职务：</td>
		<td><input type="text" name="business" value="" /></td>
	</tr>
	<tr>
		<td width="120px" class="td_pad">添加信息数量：</td>
		<td><input type="text" name="count" value="" /></td>
	</tr>
	<tr>
		<td align="center" colspan="2" class="td_pad">
		<input type="submit" value="添加" /> &nbsp;&nbsp; <input type="reset"
			value="取消" /></td>
	</tr>
</table>
</form>
</div>
<!-- 信息添加成功后的提示信息 -->
<script type="text/javascript">
		<c:if test="${succ!=null}">
			alert("${succ}");
		</c:if>	
</script>
</body>
</html>