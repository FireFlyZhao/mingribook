<%@ page language="java" contentType="text/html" pageEncoding="GBK"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>����Servlet������</title>
    <!--
	<link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <script type="text/javascript">
    	function calc(form){
			with(form){
				if(firstNum.value == "" || secendNum.value == ""){
					alert("���������֣�");
					return false;
				}
				if(isNaN(firstNum.value) || isNaN(secendNum.value)){
					alert("���ָ�ʽ����");
					return false;
				}
				if(operator.value == "-1"){
					alert("��ѡ���������");
					return false;
				}
			}
    	}
    </script>
  </head>
  
  <body>
  	<form action="CalculateServlet" method="post" onsubmit="return calc(this);">
	    <table align="center" border="0">
	    	<tr>
	    		<th>����Servlet������</th>
	    	</tr>
	    	<tr>
	    		<td>
	    			<input type="text" name="firstNum">
	    			<select name="operator">
	    				<option value="-1">�����</option>
	    				<option value="+">+</option>
	    				<option value="-">-</option>
	    				<option value="*">*</option>
	    				<option value="/">/</option>
	    			</select>
	    			<input type="text" name="secendNum">
	    			<input type="submit" value="����">
	    		</td>
	    	</tr>
	    </table>
	</form>
  </body>
</html>
