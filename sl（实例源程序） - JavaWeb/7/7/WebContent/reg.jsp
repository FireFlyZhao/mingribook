<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>������</title>
</head>

<body>
	<jsp:useBean id="paper" class="com.lyq.bean.Paper"></jsp:useBean>
	<jsp:useBean id="convert" class="com.lyq.bean.Convert"></jsp:useBean>
	<jsp:setProperty property="*" name="paper"/>
	<div>
		<h1>������</h1>
		<hr/>
		<ul>
			<li>
				�㾭��ʹ�õı�����ԣ�<%= convert.arr2Str(paper.getLanguages()) %> ��
			</li>
			<li>
				��Ŀǰ�����յļ�����<%= convert.arr2Str(paper.getTechnics()) %> ��
			</li>
			<li>
				��ѧϰ�ио������ѵĲ��֣�<%= convert.arr2Str(paper.getParts()) %> ��
			</li>
		</ul>
	</div>
</body>
</html>