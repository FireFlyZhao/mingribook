<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>�����ʾ�</title>
</head>

<body>
	<form action="reg.jsp" method="post">
		<div>
			<h1>�����ʾ�</h1>
			<hr/>
			<ul>
				<li>�㾭������Щ������Կ�������</li>
				<li>
					<input type="checkbox" name="languages" value="JAVA">JAVA
					<input type="checkbox" name="languages" value="PHP">PHP
					<input type="checkbox" name="languages" value=".NET">.NET
					<input type="checkbox" name="languages" value="VC++">VC++
				</li>
			</ul>
			<ul>
				<li>��Ŀǰ�����յļ�����</li>
				<li>
					<input type="checkbox" name="technics" value="HTML">HTML
					<input type="checkbox" name="technics" value="JAVA BEAN">JAVA BEAN
					<input type="checkbox" name="technics" value="JSP">JSP
					<input type="checkbox" name="technics" value="SERVLET">SERVLET
				</li>
			</ul>
			<ul>
				<li>��ѧϰ����һ���ָо������ѣ�</li>
				<li>
					<input type="checkbox" name="parts" value="JSP">JSP
					<input type="checkbox" name="parts" value="STRUTS">STRUTS
				</li>
			</ul>
			&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="�ᡡ��">
		</div>
	</form>
</body>
</html>