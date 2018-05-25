<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
<style type="text/css">
	*{font-size: 12px;}
</style>
</head>
<body>
  <form action="greeting.action" method="post">
  	请输入你的姓名：<input type="text" name="username">
  	<input type="submit" value="提交">
  </form>
</body>
</html>