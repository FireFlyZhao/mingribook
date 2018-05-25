<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>预览九宫格日记</title>
<style>
ul{		/*设置<ul>标记的样式*/
	list-style: none;
}
li{		/*设置<li>标记的样式*/
	padding:5px;
}
</style>
<script language="javascript">
window.onload=function(){								//当页面载入后
	document.getElementById("diaryImg").src="CreateImg";
}
</script>
</head>
<body  bgcolor="#F0F0F0">
<div id="box">
<%@ include file="top.jsp" %>
<div>
<ul>
<li>标题：${sessionScope.title }</li>
<li><img src="images/loading.gif" name="diaryImg" id="diaryImg"/></li>
<li style="padding-left:240px;">
	<a href="#" onclick="history.back();">再改改</a> &nbsp;&nbsp;
	<a href="DiaryServlet?action=save">保存</a>
</li>
</ul>
</div>
<c:if test="${empty sessionScope.userName}">
	<c:redirect url="index.jsp"/>
</c:if>
 <%@ include file="bottom.jsp" %>
</div>
</body>
</html>