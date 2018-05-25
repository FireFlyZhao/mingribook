<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加产品信息</title>
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
	font-size: 12px;
}
#main{
	width:240px;
	border:solid 1px #000000;
}
</style>
</head>
<body>
	<form action="<%=request.getContextPath()%>/AddProduct" method="post">
		<div id="main">
		<table>
			<tr>
				<th align="center" colspan="2">添加产品信息</th>
			</tr>
			<tr><td></td></tr>
			<tr>
				<td>产品名称</td>
				<td><input type="text" name="name" value=""/></td>
			</tr>
			<tr>
				<td>产品价格</td>
				<td><input type="text" name="price" value=""/>元</td>
			</tr>
			<tr>
				<td>生成商</td>
				<td><select name="factory">
						<c:forEach items="${list}" var="list">
							<option value="${list.factoryId}">${list.factoryName}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td align="center" colspan="2">
					<br/>
					<input type="submit" value="添加"/>
					<input type="reset" value="取消"/>
				</td>
			</tr>
		</table>
		</div>
	</form>
</body>
</html>