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
</head>
<body>
	<table align="center" width="450" border="1" height="180" bordercolor="white" bgcolor="black" cellpadding="1" cellspacing="1">
		<tr bgcolor="white">
			<td align="center" colspan="5">
				<h2>����ѧ����Ϣ</h2>
			</td>
		</tr>
		<tr align="center" bgcolor="#e1ffc1" >
			<td><b>ѧ��</b></td>
			<td><b>����</b></td>
			<td><b>�Ա�</b></td>
			<td><b>����</b></td>
			<td><b>�༶</b></td>
		</tr>
			<%
				// ��ȡͼ����Ϣ����
						List<Student> list = (List<Student>)request.getAttribute("list");
						// �жϼ����Ƿ���Ч
						if(list == null || list.size() < 1){
							out.print("û�����ݣ�");
						}else{
							// ����ͼ�鼯���е�����
							for(Student s : list){
			%>
				<tr align="center" bgcolor="white">
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
</body>
</html>