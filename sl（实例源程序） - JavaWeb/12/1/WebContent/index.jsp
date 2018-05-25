<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>应用&lt;c:out&gt;标签输出字符串“水平线标记&lt;hr&gt;”</title>
</head>
<body>
escapeXml属性为true时：
<c:out value="水平线标记<hr>" escapeXml="true"></c:out>
<br>
escapeXml属性为false时：
<c:out value="水平线标记<hr>" escapeXml="false"></c:out>
</body>
</html>
