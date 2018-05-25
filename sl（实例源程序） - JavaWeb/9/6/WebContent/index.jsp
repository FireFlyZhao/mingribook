<%@ page language="java" contentType="text/html" pageEncoding="GBK"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>�������</title>
		<style type="text/css">
			body {
				margin: 0px;
				font-size: 12px;
			}
			td{
				font-size: 12px;
			}
			.div1{
				width: 1003px;
				height: 707px;
				background-image: url("images/bg.jpg");
			}
			.div2{
				width: 500px;
				margin-top:245px;
				margin-left:180px;
				text-align:left;
			}
			.tl{
				width: 500px;
				height: 20px;
				font-weight: bold;
				background: #A3C0C6;
				padding: 5px;
			}
			.ct{
				width: 500px;
				padding-left: 30px;
				padding-top: 5px;
				padding-bottom: 5px;
			}
			.tt{
				margin-left:5px;
				width: 70px;
				background: #A3C0C6;
				padding: 5px;
				font-weight: bold;
				font-size: 13px;
			}
		</style>
	</head>

	<body>
		<div align="center">
			<div class="div1">
				<div class="div2">
					<%
						String title = (String)request.getAttribute("title");
						String content = (String)request.getAttribute("content");
						if(title != null && !title.isEmpty()){
							out.println("<span class='tl'>" + title + "</span>");
						}
						if(content != null && !content.isEmpty()){
							out.println("<span class='ct'>" + content + "</span>");
						}
					%>
					<span class="tl">лл����</span>
					<span class="ct">���ǵĹ�˾����̬�ȷǳ��ã�лл���ǣ�</span>
					<span class="tl">лл����</span>
					<span class="ct">���ǵĹ�˾����̬�ȷǳ���<br>�����ֿͷ�����̬�Ȼ�Ҫ��ǿ��</span>
					<form action="MessageServlet" method="post">
						<span class="tt">�������</span>
						<table border="0" width="500" align="center">
							<tr>
								<td align="right">�� �⣺</td>
								<td><input type="text" name="title" size="30"></td>
							</tr>
							<tr>
								<td align="right">�� �ݣ�</td>
								<td>
									<textarea rows="5" cols="40" name="content"></textarea>
								</td>
							</tr>
							<tr>
								<td align="center" colspan="2">
									<input type="submit" value="�� ��">
								</td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
		
	</body>
</html>
