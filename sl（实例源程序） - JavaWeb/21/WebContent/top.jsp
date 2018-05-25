<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <style>
#notClickDiv{
	filter:alpha(Opacity=35);opacity:0.35;		/*设置不透明度为35%*/
	background:#000000;						/*设置背景为黑色*/
	position:absolute;							/*设置定位方式为绝对位置*/
	display:none;								/*设置该<div>标记显示*/
	z-index:9;									/*设置层叠顺序*/
	top:0px;									/*设置顶边距*/
	left:0px;									/*设置左边距*/
	margin: 0px;
	padding: 0px;
}

</style>
<script language="javascript" src="JS/AjaxRequest.js"></script>

<script language="javascript">

function myClose(divID){
	divID.style.display='none';			//设置id为login的层隐藏
     //设置id为notClickDiv的层隐藏
	 document.getElementById("notClickDiv").style.display='none';	
}
function Myopen(divID){ 								//根据传递的参数确定显示的层
     var notClickDiv=document.getElementById("notClickDiv");	//获取id为notClickDiv的层
	 notClickDiv.style.display='block';						//设置层显示
	  document.getElementById("notClickDiv").style.width=document.body.clientWidth;
	  document.getElementById("notClickDiv").style.height=document.body.clientHeight;
      document.getElementById(divID).style.display='block';							//设置由divID所指定的层显示	 
     document.getElementById(divID).style.left=(document.body.clientWidth-240)/2;		//设置由divID所指定的层的左边距
      document.getElementById(divID).style.top=(document.body.clientHeight-139)/2;		//设置由divID所指定的层的顶边框
}
function loginSubmit(form2){
	if(form2.username.value==""){		//验证用户名是否为空
		alert("请输入用户名！");form2.username.focus();return false;
	}
	if(form2.pwd.value==""){		//验证密码是否为空
		alert("请输入密码！");form2.pwd.focus();return false;
	}	
	var param="username="+form2.username.value+"&pwd="+form2.pwd.value; 	//将登录信息连接成字符串，作为发送请求的参数
	var loader=new net.AjaxRequest("UserServlet?action=login",deal_login,onerror,"POST",encodeURI(param));
}
function onerror(){
	alert("您的操作有误");
}
function deal_login(){
	/*****************显示提示信息******************************/
	var h=this.req.responseText;
	h=h.replace(/\s/g,"");	//去除字符串中的Unicode空白
	alert(h);
	if(h=="登录成功！"){
		window.location.href="DiaryServlet?action=listAllDiary";
	}else{
		form2.username.value="";//清空用户名文本框 
		form2.pwd.value="";//清空密码文本框
		form2.username.focus();//让用户名文本框获得焦点
	}
	
}
</script>
<style>
#top{					/*设置页面头部的DIV样式*/
	background-image:url(images/bg_top.jpg);
	width:800px;
	height:176px;
}
#navigation{			/*设置导航条的样式*/
	background-image:url(images/navigation_bg.jpg);
	width:790px;
	height:26px;
	padding:5px 5px 0px 5px;
	margin: 0px;
}
#loginUl{				/*设置登录所用的<ul>标记的样式*/
	list-style:none;
	margin: 0px;
}
#loginUl li{			/*设置登录所用的<li>标记的样式*/
	padding: 5px;
}
#loginTitle{			/*设置登录窗口的标题样式*/
	padding:15px;
	background-color:#FCFBF0;
	color:#1B7F5D;
	font-size: 14px;
	font-weight:bold;
	margin:0px;
}
#login{
	position:absolute;	/*设置布局方式*/
	width:280px;		/*设置宽度*/
	padding:4px;		/*设置内边距*/
	height:156px;		/*设置高度*/
	display:none; 		/*设置显示方式*/
	z-index:10;					/*设置层叠顺序*/
	background-color:#546B51;	/*设置背景颜色*/
}
</style>
<link rel="stylesheet" href="CSS/style.css" />
<div id="notClickDiv"></div>
<div id="top"></div>
<div id="navigation">
	<div style="float:left;color:#006700;">
	<c:if test="${!empty sessionScope.userName}">		
		<b> &nbsp; 》&nbsp; 欢迎 ${sessionScope.userName} 登录九宫格日记网！</b>
	</c:if>
	<c:if test="${empty sessionScope.userName}">		
		<b> &nbsp; 》&nbsp; 欢迎光临九宫格日记网！</b>
	</c:if>
	</div>
	<div style="float:right;text-align: right;">
		<a href="DiaryServlet?action=listAllDiary">首页</a> 
	<c:if test="${empty sessionScope.userName}">	
		&nbsp; | &nbsp;<a href="#" onClick="Myopen('login')">登录</a>
		&nbsp; | &nbsp;<a href="#" onClick="Regopen('register')">注册</a>
		&nbsp; | &nbsp;<a href="forgetPwd_1.jsp">找回密码</a>	 
	</c:if>
	<c:if test="${!empty sessionScope.userName}">		
		&nbsp;| &nbsp;<a href="DiaryServlet?action=listMyDiary">我的日记</a>
		&nbsp; | &nbsp;<a href="writeDiary.jsp">写九宫格日记</a>
		&nbsp; | &nbsp;<a href="UserServlet?action=exit">退出登录</a>
	</c:if>
	</div>

</div>
 <div id="login">
<form name="form2" method="post" action="" id="form2">
	<div id="loginTitle">清爽夏日九宫格日记网--用户登录</b></div>
	<div id="loginContent" style="background-color:#FFFEF9; margin:0px;">
	<ul id="loginUl"><li>
	用户名：<input type="text" name="username" style="width:120px" onkeydown="if(event.keyCode==13){this.form.pwd.focus();}">
	</li><li>
	密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="pwd"  style="width:120px" onkeydown="if(event.keyCode==13){loginSubmit(this.form)}">&nbsp;<a href="forgetPwd_1.jsp">找回密码</a>
	</li><li style="padding-left:40px;">
	<input name="Submit" type="button"  onclick="loginSubmit(this.form)" value="登录">
      &nbsp;
        <input name="Submit2" type="button" value="关闭" onClick="myClose(login)">
	</li></ul>
	</div>
 	<div style="background-color:#FEFEFC;height:10px;"></div>
</form>
 </div>