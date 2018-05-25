<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>学生信息</title>
<style type="text/css">
	li.{font-size: 12px;}
</style>
</head>
<body>
	<jsp:useBean id="student" class="com.lyq.bean.Student">
		<jsp:setProperty property="id" name="student" value="1"/>
		<jsp:setProperty property="name" name="student" value="李*强"/>
		<jsp:setProperty property="sex" name="student" value="男"/>
		<jsp:setProperty property="age" name="student" value="18"/>
		<jsp:setProperty property="classes" name="student" value="三年一班"/>
	</jsp:useBean>
	<h2>学生信息</h2>
	<ul>
		<li>
			学号：<%=student.getId() %>
		</li>
		<li>
			姓名：<%=student.getName() %>
		</li>
		<li>
			性别：<%=student.getSex() %>
		</li>
		<li>
			年龄：<%=student.getAge() %>
		</li>
		<li>
			班级：<%=student.getClasses() %>
		</li>
	</ul>
</body>
</html>