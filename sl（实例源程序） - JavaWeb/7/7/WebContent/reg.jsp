<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>调查结果</title>
</head>

<body>
	<jsp:useBean id="paper" class="com.lyq.bean.Paper"></jsp:useBean>
	<jsp:useBean id="convert" class="com.lyq.bean.Convert"></jsp:useBean>
	<jsp:setProperty property="*" name="paper"/>
	<div>
		<h1>调查结果</h1>
		<hr/>
		<ul>
			<li>
				你经常使用的编程语言：<%= convert.arr2Str(paper.getLanguages()) %> 。
			</li>
			<li>
				你目前所掌握的技术：<%= convert.arr2Str(paper.getTechnics()) %> 。
			</li>
			<li>
				在学习中感觉有困难的部分：<%= convert.arr2Str(paper.getParts()) %> 。
			</li>
		</ul>
	</div>
</body>
</html>