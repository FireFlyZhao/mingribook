<%@ page contentType="text/html;charset=gb2312" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<h3>�����û������û��Ƿ����</h3>
<s:set name="score" value="#parameters.score[0]"/>
��ѯ����ǣ�
<s:if test="#score==mrs">
	����
</s:if>
<s:elseif test="#score==mrsoft">
	����
</s:elseif>
<s:else>
	������
</s:else>
