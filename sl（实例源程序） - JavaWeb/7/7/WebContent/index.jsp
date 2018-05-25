<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>调查问卷</title>
</head>

<body>
	<form action="reg.jsp" method="post">
		<div>
			<h1>调查问卷</h1>
			<hr/>
			<ul>
				<li>你经常用哪些编程语言开发程序：</li>
				<li>
					<input type="checkbox" name="languages" value="JAVA">JAVA
					<input type="checkbox" name="languages" value="PHP">PHP
					<input type="checkbox" name="languages" value=".NET">.NET
					<input type="checkbox" name="languages" value="VC++">VC++
				</li>
			</ul>
			<ul>
				<li>你目前所掌握的技术：</li>
				<li>
					<input type="checkbox" name="technics" value="HTML">HTML
					<input type="checkbox" name="technics" value="JAVA BEAN">JAVA BEAN
					<input type="checkbox" name="technics" value="JSP">JSP
					<input type="checkbox" name="technics" value="SERVLET">SERVLET
				</li>
			</ul>
			<ul>
				<li>在学习中哪一部分感觉有困难：</li>
				<li>
					<input type="checkbox" name="parts" value="JSP">JSP
					<input type="checkbox" name="parts" value="STRUTS">STRUTS
				</li>
			</ul>
			&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="提　交">
		</div>
	</form>
</body>
</html>