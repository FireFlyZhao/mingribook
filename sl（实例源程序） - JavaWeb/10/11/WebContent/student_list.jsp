<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@page import="java.util.List"%>
<%@page import="com.lyq.bean.Student"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
<style type="text/css">
	td{font-size: 12px;}
	h2{margin: 0px}
</style>
<script type="text/javascript">
	function check(){
		var ids = document.getElementsByName("id");
		for(var i=0;i<ids.length;i++){
			if(ids[i].checked){
				return true;
			}
		}
		alert("请选择要删除的学生信息！");
		return false;
	}
</script>
</head>
<body>
	<form action="DeleteStudent" method="post" onsubmit="return check();">
	<table align="center" width="450" border="1" height="180" bordercolor="white" bgcolor="black" cellpadding="1" cellspacing="1">
		<tr bgcolor="white">
			<td align="center" colspan="6">
				<h2>所有学生信息</h2>
			</td>
		</tr>
		<tr align="center" bgcolor="#e1ffc1" >
			<td>
				<input type="submit" value="批量删除">
			</td>
			<td><b>学号</b></td>
			<td><b>姓名</b></td>
			<td><b>性别</b></td>
			<td><b>年龄</b></td>
			<td><b>班级</b></td>
		</tr>
			<%
				// 获取图书信息集合
						List<Student> list = (List<Student>)request.getAttribute("list");
						// 判断集合是否有效
						if(list == null || list.size() < 1){
							out.print("没有数据！");
						}else{
							// 遍历图书集合中的数据
							for(Student s : list){
			%>
				<tr align="center" bgcolor="white">
					<td>
						<input type="checkbox" name="id" value="<%=s.getId()%>">
					</td>
					<td><%=s.getId()%></td>
					<td><%=s.getName()%></td>
					<td><%=s.getSex()%></td>
					<td><%=s.getAge()%></td>
					<td><%=s.getClasses()%></td>
				</tr>
			<%
					}
				}
			%>
	</table>
	</form>
</body>
</html>