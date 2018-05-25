<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ taglib uri="/codeShift" prefix="wghfn"%>
用户名：${wghfn:codeShift(param.username)}
<br>
密&nbsp;&nbsp;码：${wghfn:codeShift(param.pwd)}
<br>
<a href="index.jsp">返回</a>