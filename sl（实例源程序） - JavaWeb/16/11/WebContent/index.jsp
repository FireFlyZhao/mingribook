<%@page contentType="text/html" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>���ͼ��</title>
<link href="images/css.css" type="text/css" rel="stylesheet" />
<script type="text/javascript">
	function add(){
		var bookName = document.getElementById("bookName");
		if(bookName.value == ""){
			alert("ͼ�����Ʋ���Ϊ�գ�");
			return false;
		}
		var price = document.getElementById("price");
		if(price.value == ""){
			alert("���۲���Ϊ�գ�");
			return false;
		}
		if(isNaN(price.value) || price.value <= 0){
			alert("������Ч��");
			return false;
		}
		var bookCount = document.getElementById("bookCount");
		if(bookCount.value == ""){
			alert("ͼ����������Ϊ�գ�");
			return false;
		}
		if(isNaN(bookCount.value) || bookCount.value <= 0){
			alert("������Ч��");
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
			<td align="right">ͼ�����ƣ�</td>
			<td><input id="bookName" name="bookName" type="text"></td>
			<td align="right">���ۣ�</td>
			<td><input id="price" name="price" type="text"></td>
		</tr>
		<tr>
			<td align="right">ͼ�����</td>
			<td>
				<select name="category">
					<option value="�����ͼ��">�����ͼ��</option>
					<option value="��ѧͼ��">��ѧͼ��</option>
					<option value="��Сѧͼ��">��Сѧͼ��</option>
				</select>
			</td>
			<td align="right">������</td>
			<td><input id="bookCount" name="bookCount" type="text"></td>
		</tr>
		<tr>
			<td align="right">������</td>
			<td colspan="3"><textarea name="description" cols="30" rows="3"></textarea></td>
		</tr>
		<tr>
			<td colspan="4" align="center">
				<input type="submit" value="�� ��">
				<input type="reset" value="�� ��">
			</td>
		</tr>
	</table>
	</form>
	
	<c:if test="${books != null}">
		<table border="0" width="500" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td><b>ͼ������</b></td><td><b>ͼ�����</b></td>
				<td><b>����</b></td><td><b>����</b></td>
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
						<input type="submit" value="���浽���ݿ�">
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