<%@page contentType="text/html" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>添加图书</title>
<link href="images/css.css" type="text/css" rel="stylesheet" />
<script type="text/javascript">
	function add(){
		var bookName = document.getElementById("bookName");
		if(bookName.value == ""){
			alert("图书名称不能为空！");
			return false;
		}
		var price = document.getElementById("price");
		if(price.value == ""){
			alert("单价不能为空！");
			return false;
		}
		if(isNaN(price.value) || price.value <= 0){
			alert("单价无效！");
			return false;
		}
		var bookCount = document.getElementById("bookCount");
		if(bookCount.value == ""){
			alert("图书数量不能为空！");
			return false;
		}
		if(isNaN(bookCount.value) || bookCount.value <= 0){
			alert("数量无效！");
			return false;
		}
	}
</script>
</head>
<body>
	<table align="center" border="0" cellpadding="0" cellspacing="0" width="594">
	<tr>
		<td height="125"><img src="images/top.jpg" /></td>
	</tr>
	<tr>
		<td background="images/middle.jpg">
		<br>
		<form action="BookServlet?command=add" method="post" onsubmit="return add();">
	<table border="0" align="center" width="500">
		<tr>
			<td align="right">图书名称：</td>
			<td><input id="bookName" name="bookName" type="text"></td>
			<td align="right">单价：</td>
			<td><input id="price" name="price" type="text"></td>
		</tr>
		<tr>
			<td align="right">图书类别：</td>
			<td>
				<select name="category">
					<option value="计算机图书">计算机图书</option>
					<option value="文学图书">文学图书</option>
					<option value="中小学图书">中小学图书</option>
				</select>
			</td>
			<td align="right">数量：</td>
			<td><input id="bookCount" name="bookCount" type="text"></td>
		</tr>
		<tr>
			<td align="right">描述：</td>
			<td colspan="3"><textarea name="description" cols="30" rows="3"></textarea></td>
		</tr>
		<tr>
			<td colspan="4" align="center">
				<input type="submit" value="添 加">
				<input type="reset" value="重 置">
			</td>
		</tr>
	</table>
	</form>
	
	<c:if test="${books != null}">
		<table border="0" width="500" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td><b>图书名称</b></td><td><b>图书类别</b></td>
				<td><b>单价</b></td><td><b>数量</b></td>
			</tr>
			<c:forEach items="${books}" var="b">
				<tr>
					<td>${b.bookName}</td>
					<td>${b.category}</td>
					<td>${b.price}</td>
					<td>${b.bookCount}</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="4" align="right" height="30" valign="middle">
					<form action="BookServlet?command=save" method="post">
						<input type="submit" value="保存到数据库">
					</form>
				</td>
			</tr>
		</table>
	</c:if>	
		</td>
	</tr>
	<tr>
		<td height="26"><img src="images/foot.jpg" /></td>
	</tr>
</table>
</body>
</html>