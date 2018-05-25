<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${empty sessionScope.userName}">
	<c:redirect url="index.jsp"/>
</c:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 使用JQuery解决PNG图片背景不透明的问题 -->
	<script type="text/javascript" src="JS/jquery-1.3.2.min.js"></script>
	<script type="text/javascript" src="JS/pluginpage.js"></script>
	<script type="text/javascript" src="JS/jquery.pngFix.pack.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('div.examples').pngFix( );
	});
</script>
<!-- ******************************* -->
<title>写九宫格日记</title>
<link rel="stylesheet" href="CSS/style.css">
<style>
#gridLayout { /*设置写日记的九宫格的<ul>标记的样式*/
	float: left; /*设置浮动方式*/
	list-style: none; /*不显示项目符号*/
	width: 100%; /*设置宽度为100%*/
	margin: 0px; /*设置外边距*/
	padding: 0px; /*设置内边距*/
	display: inline; /*设置显示方式*/
}

#gridLayout li { /*设置写日记的九宫格的<li>标记的样式*/
	width: 33%; /*设置宽度*/
	float: left; /*设置浮动方式*/
	height: 198px; /*设置高度*/
	padding: 0px; /*设置内边距*/
	margin: 0px; /*设置外边距*/
	display: inline; /*设置显示方式*/
}
#opt{									/*设置默认选项相关的<ul>标记的样式 */
	padding:0px 0px 0px 10px;	/*设置上、右、下内边距为0，左内边距为10*/
	margin:0px;					/*设置外边距*/
}
#opt li{								/*设置默认选项相关的<li>标记的样式 */
	width:99%;
	padding-top:5px 0px 0px 10px;
	font-size:14px;				/*设置字体大小为14像素*/
	height:25px;				/*设置高度*/
	clear:both;					/*左、右两侧不包含浮动内容*/
}
.cssContent{							/*设置内容的样式*/
	float:left;
	padding:40px 0px;					/*设置上、下内边距为40，左、右内边距为0*/
	display:inline;						/*设置显示方式*/
}
#weather{								/*设置天气相关<ul>标记的样式*/
	border:0px;
	padding:15px 0px 0px 30px;
	margin:20px;
	display:inline;

}
#weather li{							/*设置天气相关<li>标记的样式*/
	border:0px;
	width:90%;
	padding:10px;
	margin:0px;
	display:inline;	
}
input{									/*设置输入框的样式*/
	font-size:12px;
}
.title{									/*设置标题的样式*/
color:#0F6548;
font-weight:bold;
}
#writeDiary_bg{							/*设置日记背景的样式*/
width:738px;							/*设置宽度*/
height:751px;						/*设置高度*/
background-repeat:no-repeat;							/*设置背景不重复*/
background-image:url(images/diaryBg_00.jpg);						/*设置默认的背景图片*/
padding-top:50px;						/*设置顶边距*/
padding-left:53px;						/*设置左边距*/
}
</style>
<script language="javascript">
function setTemplate(style){
	if(style=="默认"){
		document.getElementById("writeDiary_bg").style.backgroundImage="url(images/diaryBg_00.jpg)";
		document.getElementById("writeDiary_bg").style.width="738px";	//宽度
		document.getElementById("writeDiary_bg").style.height="751px";	//高度
		document.getElementById("writeDiary_bg").style.paddingTop="50px";//顶边距
		document.getElementById("writeDiary_bg").style.paddingLeft="53px";//左边距
		document.getElementById("template").value="默认";
	}else if(style=="女孩"){
		document.getElementById("writeDiary_bg").style.backgroundImage="url(images/diaryBg_01.jpg)";
		document.getElementById("writeDiary_bg").style.width="750px";	//宽度
		document.getElementById("writeDiary_bg").style.height="629px";	//高度
		document.getElementById("writeDiary_bg").style.paddingTop="160px";//顶边距
		document.getElementById("writeDiary_bg").style.paddingLeft="50px";//左边距
		document.getElementById("template").value="女孩";
	}else{
		document.getElementById("writeDiary_bg").style.backgroundImage="url(images/diaryBg_02.jpg)";
		document.getElementById("writeDiary_bg").style.width="740px";	//宽度
		document.getElementById("writeDiary_bg").style.height="728px";	//高度
		document.getElementById("writeDiary_bg").style.paddingTop="30px";//顶边距
		document.getElementById("writeDiary_bg").style.paddingLeft="60px";	//左边距
		document.getElementById("template").value="怀旧";
	}
}
window.onload=function(){
	var date=new Date();		//创建日期对象
	year=date.getFullYear();	//获取当前日期中的年份
	month=date.getMonth();		//获取当前日期中的月份
	day=date.getDate();			//获取当时日期中的日
	week=date.getDay();			//获取当前日期中的星期
	var arr=new Array("星期日","日期一","星期二","星期三","星期四","星期五","星期六");
	document.getElementById("now").innerHTML=year+"年"+(month+1)+"月"+day+"日 "+arr[week];
}

</script>
</head>
<body  bgcolor="#F0F0F0">
<div id="box">
<%@ include file="top.jsp" %>
<c:if test="${empty sessionScope.userName}">
	<c:redirect url="index.jsp"/>
</c:if>
<form name="form1" method="post" action="DiaryServlet?action=preview">
<div style="margin:10px;"><span class="title">请选择模板：</span><a href="#" onClick="setTemplate('默认')">默认</a> <a href="#" onClick="setTemplate('女孩')">女孩</a> <a href="#" onClick="setTemplate('怀旧')">怀旧</a>
	<input id="template" name="template" type="hidden" value="默认">
</div>
<div style="padding:10px;" class="title">请输入日记标题： <input name="title" type="text" size="30" maxlength="30" value="请在此输入标题" onFocus="this.select()"></div>
<div id="writeDiary_bg">




<div style="width:600px; height:600px; ">
<ul id="gridLayout">
<li>
	<div class="cssContent">
		<ul id="opt">
		<li>
	 	 <input name="content" type="text" size="30" maxlength="15" value="请在此输入文字" onFocus="this.select()">
	  	</li>
	   	<li><a href="#" onClick="document.getElementsByName('content')[0].value='工作完成了'">◎ 工作完成了</a></li>
	   	<li><a href="#" onClick="document.getElementsByName('content')[0].value='我还活着'">◎ 我还活着</a></li>
	   	<li><a href="#" onClick="document.getElementsByName('content')[0].value='瘦了'">◎ 瘦了</a></li>
	  	<li><a href="#" onClick="document.getElementsByName('content')[0].value='好多好吃的'">◎ 好多好吃的</a></li>
	  	</ul>
	</div>
</li>
<li>
	<div class="cssContent">
		<ul id="opt">
		<li>
	  <input name="content" type="text" size="30" maxlength="15" value="请在此输入文字" onFocus="this.select()">
	  </li>
	   <li><a href="#" onClick="document.getElementsByName('content')[1].value='关心同事'">◎ 关心同事</a></li>
	   <li><a href="#" onClick="document.getElementsByName('content')[1].value='问候家人了'">◎ 问候家人了</a></li>
	   <li><a href="#" onClick="document.getElementsByName('content')[1].value='给老人让坐'">◎ 给老人让坐</a></li>
	   <li><a href="#" onClick="document.getElementsByName('content')[1].value='忘记了'">◎ 忘记了</a></li></ul>
	</div>
</li>
<li>
	<div class="cssContent">
		<ul id="opt">
		<li>
	  <input name="content" type="text" size="30" maxlength="15" value="请在此输入文字" onFocus="this.select()">
	  </li>
	   <li><a href="#" onClick="document.getElementsByName('content')[2].value='写工作总结'">◎ 写工作总结</a></li>
	   <li><a href="#" onClick="document.getElementsByName('content')[2].value='出去旅游'">◎ 出去旅游</a></li>
	   <li><a href="#" onClick="document.getElementsByName('content')[2].value='继续努力工作'">◎ 继续努力工作</a></li>
	   <li><a href="#" onClick="document.getElementsByName('content')[2].value='休息一下'">◎ 休息一下</a></li></ul>
	</div>
</li>
<li>
	<div class="cssContent">
		<ul id="opt">
		<li>
	  <input name="content" type="text" size="30" maxlength="15" value="请在此输入文字" onFocus="this.select()">
	  </li>
	   <li><a href="#" onClick="document.getElementsByName('content')[3].value='效率提高了'">◎ 效率提高了</a></li>
	   <li><a href="#" onClick="document.getElementsByName('content')[3].value='看书了'">◎ 看书了</a></li>
	   <li><a href="#" onClick="document.getElementsByName('content')[3].value='状态好了'">◎ 状态好了</a></li>
	   <li><a href="#" onClick="document.getElementsByName('content')[3].value='不再空想了'">◎ 不再空想了</a></li></ul>
	</div>
</li>
<li>
	<ul id="weather"><li style="height:27px;"> <span id="now" style="font-size: 14px;font-weight:bold;padding-left:5px;">正在获取日期</span>
		<input name="content" type="hidden" value="weathervalue"><br></br>
		<div class="examples">
		<input name="weather" type="radio" value="1">
		<img src="images/1.png" width="30" height="30">
		<input name="weather" type="radio" value="2">
  		<img src="images/2.png" width="30" height="30">
		<input name="weather" type="radio" value="3">
  		<img src="images/3.png" width="30" height="30">
		<input name="weather" type="radio" value="4">
  		<img src="images/4.png" width="30" height="30">
		<input name="weather" type="radio" value="5" checked="checked">
  		<img src="images/5.png" width="30" height="30">
		<input name="weather" type="radio" value="6">
  		<img src="images/6.png" width="30" height="30">
		<input name="weather" type="radio" value="7">
  		<img src="images/7.png" width="30" height="30">
		<input name="weather" type="radio" value="8">
  		<img src="images/8.png" width="30" height="30">
		<input name="weather" type="radio" value="9">
  		<img src="images/9.png" width="30" height="30">
  		</div> 
	</li>
  	</ul>
</li>
<li>
	<div class="cssContent">
		<ul id="opt">
		<li>
	  <input name="content" type="text" size="30" maxlength="15" value="请在此输入文字" onFocus="this.select()">
	  </li>
	   <li><a href="#" onClick="document.getElementsByName('content')[5].value='心情不错'">◎ 心情不错</a></li>
	   <li><a href="#" onClick="document.getElementsByName('content')[5].value='不给力'">◎ 不给力</a></li>
	   <li><a href="#" onClick="document.getElementsByName('content')[5].value='幸福'">◎ 幸福</a></li>
	   <li><a href="#" onClick="document.getElementsByName('content')[5].value='神马都是浮云'">◎ 神马都是浮云</a></li></ul>
	</div>
</li>
<li>
	<div class="cssContent">
		<ul id="opt">
		<li>
	  <input name="content" type="text" size="30" maxlength="15" value="请在此输入文字" onFocus="this.select()">
	  </li>
	   <li><a href="#" onClick="document.getElementsByName('content')[6].value='她/他写九宫格日记了'">◎ 她/他写九宫格日记了</a></li>
	   <li><a href="#" onClick="document.getElementsByName('content')[6].value='白菜贵了'">◎ 白菜贵了</a></li>
	   <li><a href="#" onClick="document.getElementsByName('content')[6].value='大家都在关注神马'">◎ 大家都在关注神马</a></li>
	   <li><a href="#" onClick="document.getElementsByName('content')[6].value='新闻联播'">◎ 新闻联播</a></li></ul>
	</div>
</li>
<li>
	<div class="cssContent">
		<ul id="opt">
		<li>
	  <input name="content" type="text" size="30" maxlength="15" value="请在此输入文字" onFocus="this.select()">
	  </li>
	   <li><a href="#" onClick="document.getElementsByName('content')[7].value='瘦了'">◎ 瘦了</a></li>
	   <li><a href="#" onClick="document.getElementsByName('content')[7].value='胖了'">◎ 胖了</a></li>
	   <li><a href="#" onClick="document.getElementsByName('content')[7].value='健康饮食'">◎ 健康饮食</a></li>
	   <li><a href="#" onClick="document.getElementsByName('content')[7].value='一日三餐不能少'">◎ 一日三餐不能少</a></li></ul>
	</div>
</li>
<li>
	<div class="cssContent">
		<ul id="opt">
		<li>
	  <input name="content" type="text" size="30" maxlength="15" value="请在此输入文字" onFocus="this.select()">
	  </li>
	   <li><a href="#" onClick="document.getElementsByName('content')[8].value='睡得很好'">◎ 睡得很好</a></li>
	   <li><a href="#" onClick="document.getElementsByName('content')[8].value='拥有自己的房子'">◎ 拥有自己的房子</a></li>
	   <li><a href="#" onClick="document.getElementsByName('content')[8].value='忘记了'">◎ 忘记了</a></li>
	   <li><a href="#" onClick="document.getElementsByName('content')[8].value='努力做好自己'">◎ 努力做好自己</a></li></ul>
	</div>
</li>
</ul>
</div>



</div>
<div style="height:30px;padding-left:360px;"><input type="submit" value="预览"></div>
</form>
<%@ include file="bottom.jsp" %>
</div>
</body>
</html>