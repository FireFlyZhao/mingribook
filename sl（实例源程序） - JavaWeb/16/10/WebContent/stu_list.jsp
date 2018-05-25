<%@page contentType="text/html" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>所有学生</title>
<link href="images/css.css" type="text/css" rel="stylesheet" />
<script type="text/javascript">
	function checkAll() {
		for (var i = 0; i < document.getElementsByName("id").length; i++) {
			document.getElementsByName("id")[i].checked = document.getElementById("selectAll").checked;
		}
	}
	function del(){
		var flag = false;
		for (var i = 0; i < document.getElementsByName("id").length; i++) {
			if(document.getElementsByName("id")[i].checked){
				flag = true;
				break;
			}
		}
		if(!flag){
			alert("请选择要删除的学生！");
			return false;
		}
	}
</script>
</head>
<body>
	<table align="center" cellpadding="0" cellspacing="0" width="591">
	<tr>
		<td><img src="images/top.jpg" /></td>
	</tr>
	<tr>
		<td valign="top">
		
		<c:if test="${list != null}">
	<form action="StuServlet?command=delete" method="post" onsubmit="return del();">
	<table border="1" align="center" width="500" cellpadding="0" cellspacing="0" bordercolor="#BCCC9B">
		<tr align="center">
			<td><b>删除</b></td>
			<td><b>姓名</b></td><td><b>年龄</b></td>
			<td><b>性别</b></td><td><b>班级</b></td>
		</tr>
		<c:forEach items="${list}" var="s">
			<tr align="center">
				<td><input type="checkbox" name="id" value="${s.id}"></td>
				<td>${s.stuName}</td>
				<td>${s.age}</td>
				<td>
					<c:if test="${s.sex}">男</c:if>
					<c:if test="${!s.sex}">女</c:if>
				</td>
				<td>${s.stuClass}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5">
				<input type="checkbox" id="selectAll" onclick="checkAll()">全选/取消
				<input type="submit" value="删除"> 
			</td>
		</tr>
	</table>
	</form>
	</c:if>
		</td>
	</tr>
	<tr>
		<td><img src="images/foot.jpg" /></td>
	</tr>
</table>
</body>
</html>