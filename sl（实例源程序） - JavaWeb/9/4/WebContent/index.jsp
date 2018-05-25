<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>用户注册</title>
		<link href="css/style.css" type="text/css">
		<style type="text/css">
			body{
				margin: 0px;font-size: 12px;
			}
			.box{
				border: 1px solid #D1DEB2; width: 150px; height: 20px;
			}
			.div1{
				background-image: url(images/bg.jpg);
				height: 600px;
				width: 803px;
				padding-left:20px;
				padding-top:220px;
				text-align:left;
			}
		</style>
		<script type="text/javascript">
	    	function reg(form){
	        	if(form.username.value == ""){
	        		alert("用户不能为空！");
	        		return false;
	        	}
	        	if(form.password.value == ""){
	        		alert("密码不能为空！");
	        		return false;
	        	}
	        	if(form.repassword.value == ""){
	        		alert("确认密码不能为空！");
	        		return false;
	        	}
	        	if(form.password.value != form.repassword.value){
	        		alert("两次密码输入不一致！");
	        		return false;
	        	}
	        	if(form.question.value == ""){
	        		alert("密码找回问题不能为空！");
	        		return false;
	        	}
	        	if(form.answer.value == ""){
	        		alert("密码找回答案不能为空！");
	        		return false;
	        	}
	        	if(form.email.value == ""){
	        		alert("电子邮箱不能为空！");
	        		return false;
	        	}
	    	}
	    </script>
	</head>
	<body>
		<div align="center">
			<div class="div1">
				<form action="SaveServlet" method="post" onsubmit="return reg(this);">
					<table align="center" border="0" width="500">
						<tr>
							<td align="right" width="30%" size ="9pt">用户名：</td>
							<td><input type="text" name="username" class="box"></td>
						</tr>
						<tr>
							<td align="right">密 码：</td>
							<td><input type="password" name="password" class="box"></td>
						</tr>
						<tr>
							<td align="right">确认密码：</td>
							<td><input type="password" name="repassword" class="box"></td>
						</tr>
						<tr> 
							<td align="right">性 别：</td>
							<td>
								<input type="radio" name="sex" value="男" checked="checked">男
								<input type="radio" name="sex" value="女">女
							</td>
						</tr>
						<tr>
							<td align="right">密码找回问题：</td>
							<td><input type="text" name="question" class="box"></td>
						</tr>
						<tr>
							<td align="right">密码找回答案：</td>
							<td><input type="text" name="answer" class="box"></td>
						</tr>
						<tr>
							<td align="right">邮 箱：</td>
							<td><input type="text" name="email" class="box"></td>
						</tr>
						<tr>
							<td colspan="2" align="center" height="40">
								<input type="submit" value="注 册">
								<input type="reset" value="重 置">
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</body>
</html>
