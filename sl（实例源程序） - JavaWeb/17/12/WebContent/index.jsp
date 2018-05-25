<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公民信息列表</title>
<style type="text/css">
table {
	border-left:5px solid #ffffff;
	border-collapse: collapse;
}
td {
	font: normal 12px/ 17px Arial;
	padding: 2px;
}
th {
	font: bold 12px/ 17px Arial;
	padding: 4px;
	border-bottom: 1px solid #333;
}
body {
	font-size: 14px;
}
#main{
	width:300px;
	border:solid 1px #000000;
}
</style>
</head>
<body>
<div id="main">
<table>
	<tr>
		<th width="30px">编号</th>
		<th width="30px">姓名</th>
		<th width="30px" align="center">性别</th>
		<th width="30px">年龄</th>
		<th width="135px">身份证号</th>
	</tr>
	<c:forEach items="${list}" var="list">
		<tr>
			<td align="center">${list[0]}</td>
			<td>${list[1]}</td>
			<td>${list[2]}</td>
			<td>${list[3]}</td>
			<td>${list[4]}</td>
		</tr>
	</c:forEach>
</table>
</div>
</body>
</html>