<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>ѧ����Ϣ</title>
<style type="text/css">
	li.{font-size: 12px;}
</style>
</head>
<body>
	<jsp:useBean id="student" class="com.lyq.bean.Student">
		<jsp:setProperty property="id" name="student" value="1"/>
		<jsp:setProperty property="name" name="student" value="��*ǿ"/>
		<jsp:setProperty property="sex" name="student" value="��"/>
		<jsp:setProperty property="age" name="student" value="18"/>
		<jsp:setProperty property="classes" name="student" value="����һ��"/>
	</jsp:useBean>
	<h2>ѧ����Ϣ</h2>
	<ul>
		<li>
			ѧ�ţ�<%=student.getId() %>
		</li>
		<li>
			������<%=student.getName() %>
		</li>
		<li>
			�Ա�<%=student.getSex() %>
		</li>
		<li>
			���䣺<%=student.getAge() %>
		</li>
		<li>
			�༶��<%=student.getClasses() %>
		</li>
	</ul>
</body>
</html>