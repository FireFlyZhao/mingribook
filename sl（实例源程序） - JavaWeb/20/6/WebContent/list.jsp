<%@ page language="java" contentType="text/html" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>ѧ����Ϣ</title>
		<style type="text/css">
    	#div1{
    		font-size:12px;
    		width:500px;
    		padding: 5px;
    		border: solid 1px;
    		background-color: yellow;
    	}
    	ul{
    		list-style:none;
    	}
    </style>
	</head>

	<body>
		<div>
	    	<c:forEach items="${list}" var="s">
		    	<div id="div1">
		    		<ul>
		    			<li>ѧ�ţ�${s.id}</li>
		    			<li>������${s.name}</li>
		    			<li>���䣺${s.age}</li>
		    			<li>�Ա�${s.sex}</li>
		    		</ul>
		    	</div>
		    </c:forEach>
	    </div>
	</body>
</html>
