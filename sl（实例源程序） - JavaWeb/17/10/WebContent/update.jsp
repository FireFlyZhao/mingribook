<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>修改员工信息</title>
<style type="text/css">
body {
	font-size: 14px;
}

td{
	padding:5px 0px 0px 10px;
}

#main {
	width: 530px;
	border: solid 1px #000000;
}
</style>
</head>
<body>
<form action="UpdateEmployee?id=${employeeVO.id}" method="post">
<div id="main">
<table>
	<tr>
		<td colspan="2" align="center"><b>修改员工信息</b></td>
	</tr>
	<tr>
		<td width="280px">姓名：<input type="text" name="name" value="${employeeVO.name}" /></td>
		<td>性别：<input type="radio" name="sex" value="男"
			<c:if test="${employeeVO.sex=='男'}">
				checked
			</c:if> />男&nbsp;&nbsp;
		<input type="radio" name="sex" value="女"
			<c:if test="${employeeVO.sex=='女'}">
				checked
			</c:if> />女</td>
	</tr>
	<tr>
		<td width="280px">职务：<input type="text" name="business"
			value="${employeeVO.business}"></td>
	
		<td>住址：<input type="text" name="address"
			value="${employeeVO.address}"></td>
	</tr>
	<tr>
		<td colspan="2">备注：<textarea name="remark" rows="3" cols="54">${employeeVO.remark}</textarea></td>
	</tr>
	<tr>
		<td align="center" colspan="2">
			<input type="submit" value="提交" style="width:60px"/> 
			<input type="reset" value="取消" style="width:60px"/>
		</td>
	</tr>
</table>
</div>
</form>
</body>
</html>