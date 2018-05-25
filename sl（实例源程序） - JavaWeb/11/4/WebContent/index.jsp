<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<jsp:useBean id="user" scope="page" class="com.wgh.UserInfo" type="com.wgh.UserInfo">
	<jsp:setProperty name="user" property="name" value="明日科技"/>
</jsp:useBean>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>通过pageScope隐含对象读取page范围内的JavaBean的属性值</title>
</head>
<body>
${pageScope.user.name}
</body>
</html>