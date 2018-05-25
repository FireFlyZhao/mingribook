<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>签写留言信息</title>
<script language="javascript">
function checkNull(form){
	for(i=0;i<form.length;i++){  
		if(form.elements[i].value == ""){         //form的属性elements的首字e要小写
			alert("很抱歉，"+form.elements[i].title + "不能为空!");
			form.elements[i].focus();			//当前元素获取焦点
			return false;
		}
	}
}
</script>
</head>
<body>
<%
if(session.getAttribute("message")!=null){
	out.println(session.getAttribute("message").toString());
}
%>
<br><hr></hr>
<form name="form1" method="post" action="deal.jsp" onSubmit="return checkNull(form1)">
留言人：&nbsp;&nbsp;
<input name="author" type="text" id="author" size="30" title="留言人"><br>
留言内容：
<textarea name="content" cols="70" rows="10" title="留言内容" id="content"></textarea><br>
<input name="Submit" type="submit" value="签写留言">
<input name="Submit2" type="reset" value="重置">

</form>
</body>
</html>