<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setAttribute("userName","mr"); 		//定义request范围内的变量userName
request.setAttribute("pwd","mrsoft");			//定义pwd范围内的变量pwd
%>
userName=${userName}<br>				<!-- 输入变量userName -->
pwd=${pwd}<br>						<!-- 输入变量pwd -->
\${userName!="" and (userName=="明日") }：	<!-- 将EL原样输出 -->
${userName!="" and userName=="明日" }<br>	<!-- 输出由关系和逻辑运算符组成的表达式的值 -->
\${userName=="mr" and pwd=="mrsoft" }：	<!-- 将EL原样输出 -->
${userName=="mr" and pwd=="mrsoft" }		<!-- 输出由关系和逻辑运算符组成的表达式的值 -->

</body>
</html>