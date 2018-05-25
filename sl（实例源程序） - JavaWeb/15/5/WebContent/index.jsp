<%@ page contentType="text/html;charset=gb2312" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<h3>输入用户名，用户是否存在</h3>
<s:set name="score" value="#parameters.score[0]"/>
查询结果是：
<s:if test="#score==mrs">
	存在
</s:if>
<s:elseif test="#score==mrsoft">
	存在
</s:elseif>
<s:else>
	不存在
</s:else>
