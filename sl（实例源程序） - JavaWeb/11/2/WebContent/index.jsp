<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import ="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
List<String> list = new ArrayList<String>();					//声明一个List集合的对象
list.add("饼干");											//添加第1个元素
list.add("牛奶");											//添加第2个元素
list.add("果冻");											//添加第3个元素
session.setAttribute("goodsList",list);							//将List集合保存到session对象中
%>
<%
List<String> list1=(List<String>)session.getAttribute("goodsList");	//获取保存到session范围内的变量
//通过循环和EL输出List集合的内容
for(int i=0;i<list1.size();i++){
	request.setAttribute("requestI",i);							//将循环增量保存到request范围内
%>
	
	${requestI}：${goodsList[requestI]}<br>					<!-- 输出集合中的第i个元素 -->
<%} %>

</body>
</html>