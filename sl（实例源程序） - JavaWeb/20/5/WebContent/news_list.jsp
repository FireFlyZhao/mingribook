<%@ page language="java" contentType="text/html" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>'news_list.jsp'</title>
    <!--
	<link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <style type="text/css">
    	#div1{
    		width: 450px;
    		margin: 10px;
    		font-size: 12px;
    		text-align: left;
    	}
    	li{
    		list-style: none;
    	}
    </style>
  </head>
  
  <body>
    <div align="center">
    	<div style="width: 450px; border: solid 1px;text-align: left; padding: 10px;">
	    	<font color="red">当前位置&gt;&gt;新闻内容</font>
	    	<c:forEach items="${list}" var="n">
		    	<div id="div1">
		    		<ul>
		    			<li><b>${n.title}</b>[${n.createTime}]</li>
		    			<li>${n.content}</li>
		    			<li style="text-decoration: underline;color: blue;">阅读全文</li>
		    		</ul>
		    		<hr>
		    	</div>
	    	</c:forEach>
	    	<a href="Rss.xml" target="_blank">Rss订阅</a>
	    	订阅地址:http://locahost:8080/Rss.xml
    	</div>
    </div>
  </body>
</html>
