<%@ page language="java" import="java.util.*" pageEncoding="GB18030" %>
<%
	String[] userList={"���տƼ�","mr","mrsoft","wgh"};			//����һ��һά����
	String user=new String(request.getParameter("user").getBytes("ISO-8859-1"),"GB18030");	//��ȡ�û���
	Arrays.sort(userList);									//����������	
	int result=Arrays.binarySearch(userList,user);				//��������
	if(result>-1){
		out.println("�ܱ�Ǹ�����û����Ѿ���ע�ᣡ");			//��������
	}else{
		out.println("��ϲ�������û���û�б�ע�ᣡ");			//��������
	}
%>
