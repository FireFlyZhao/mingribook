<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="produce" class="com.lyq.bean.Produce"></jsp:useBean>
	<jsp:setProperty property="name" name="produce" value="ϴ�»�"/>
	<jsp:setProperty property="price" name="produce" value="8888.88"/>
	<jsp:setProperty property="count" name="produce" value="88"/>
	<jsp:setProperty property="factoryAdd" name="produce" value="�㶫ʡxxx��˾"/>
	<div>
		<ul>
			<li>
				��Ʒ����:<jsp:getProperty property="name" name="produce"/>
			</li>
			<li>
				�۸�<jsp:getProperty property="price" name="produce"/>
			</li>
			<li>
				������<jsp:getProperty property="count" name="produce"/>
			</li>
			<li>
				��ַ��<jsp:getProperty property="factoryAdd" name="produce"/>
			</li>
		</ul>
	</div>
</body>
</html>