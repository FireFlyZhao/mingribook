<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script language="javascript" src="JS/AjaxRequest.js"></script>		
<script language="javascript" src="JS/wghFunction.js"></script>	
<script language="javascript">
//显示用户注册页面
function Regopen(divID){
	getProvince();		//获取省和直辖市	
    var notClickDiv=document.getElementById("notClickDiv");	//获取id为notClickDiv的层
	 notClickDiv.style.display='block';						//设置层显示
	  document.getElementById("notClickDiv").style.width=document.body.clientWidth;
	  document.getElementById("notClickDiv").style.height=document.body.clientHeight;
	divID=document.getElementById(divID);	//根据传递的参数获取操作的对象
	divID.style.display='block';			//显示用户注册页面
	divID.style.left=(document.body.clientWidth-663)/2;		//设置页面的左边距
	divID.style.top=(document.body.clientHeight-441)/2;		//设置页面的顶边距
}
//隐藏用户注册页面
function Myclose(divID){
	document.getElementById(divID).style.display='none';	//隐藏用户注册页面
    //设置id为notClickDiv的层隐藏
	 document.getElementById("notClickDiv").style.display='none';	
}
</script>	
<script language="javascript">
var flag_user=true;		//记录用户是否合法
var flag_pwd=true;			//记录密码是否合法
var flag_repwd=true;		//确认密码是否通过
var flag_email=true;		//记录E-mail地址是否合法
var flag_question=true;	//记录密码提示问题是否输入
var flag_answer=true;		//记录提示问题答案是否输入
//验证用户名是否合法，并且未被注册
function checkUser(str){
	if(str==""){			//当用户名为空时
		document.getElementById("div_user").innerHTML="请输入用户名！";//设置提示文字
		document.getElementById("tr_user").style.display='block';	//显示提示信息
		flag_user=false;
	}else if(!checkeUser(str)){	//判断用户名是否符合要求
		document.getElementById("div_user").innerHTML="您输入的用户名不合法！";	//设置提示文字
		document.getElementById("tr_user").style.display='block';		//显示提示信息
		flag_user=false;
	}else{		//进行异步操作，判断用户名是否被注册
		var loader=new net.AjaxRequest("UserServlet?action=checkUser&username="+str+"&nocache="+new Date().getTime(),deal,onerror,"GET");
	}	
}
function deal(){
	result=this.req.responseText;								//获取返回的检测结果
	result=result.replace(/\s/g,"");								//去除Unicode空白符
	if(result=="1"){											//当用户名没有被注册
		document.getElementById("div_user").innerHTML="";		//清空提示文字
		document.getElementById("tr_user").style.display='none';		//隐藏提示信息显示行
		flag_user=true;		
	}else{												//当用户名已经被注册
		document.getElementById("div_user").innerHTML=result;		//设置提示文字
		document.getElementById("tr_user").style.display='block';		//显示提示信息
		flag_user=false;
	}
	
}

/*************************************************************************************************************/
//验证密码
function checkPwd(str){
	if(str==""){		//当密码为空时
		document.getElementById("div_pwd").innerHTML="请输入密码！";	//设置提示文字
		document.getElementById("tr_pwd").style.display='block';		//显示提示信息
		flag_pwd=false;
	}else if(!checkePwd(str)){		//当密码不合法时
		document.getElementById("div_pwd").innerHTML="您输入的密码不合法！";	//设置提示文字
		document.getElementById("tr_pwd").style.display='block';	//显示提示信息
		flag_pwd=false;
	}else{		//当密码合法时
		document.getElementById("div_pwd").innerHTML="";	//清空提示文字
		document.getElementById("tr_pwd").style.display='none';		//隐藏提示信息显示行
		flag_pwd=true;
	}
}
//验证确认密码是否正确
function checkRepwd(str){
	if(str==""){		//当确认密码为空时
		document.getElementById("div_pwd").innerHTML="请确认密码！";	//设置提示文字
		document.getElementById("tr_pwd").style.display='block';	//显示提示信息
		flag_repwd=false;
	}else if(form1.pwd.value!=str){		//当确认密码与输入的密码不一致时
		document.getElementById("div_pwd").innerHTML="两次输入的密码不一致！";	//设置提示文字
		document.getElementById("tr_pwd").style.display='block';	//显示提示信息
		flag_repwd=false;
	}else{	//当两次输入的密码一致时
		document.getElementById("div_pwd").innerHTML="";	//清空提示文字
		document.getElementById("tr_pwd").style.display='none';		//隐藏提示信息显示行
		flag_repwd=true;
	}
}
//验证E-mail地址
function checkEmail(str){
	if(str==""){//当E-mail地址为空时
		document.getElementById("div_email").innerHTML="请输入E-mail地址！";//设置提示信息
		document.getElementById("tr_email").style.display='block';		//显示提示信息
		flag_email=false;
	}else if(!checkemail(str)){//当E-mail地址不合法时
		document.getElementById("div_email").innerHTML="您输入的E-mail地址不正确！";//设置提示信息
		document.getElementById("tr_email").style.display='block';		//显示提示信息
		flag_email=false;
	}else{
		document.getElementById("div_email").innerHTML="";//清空提示信息
		document.getElementById("tr_email").style.display='none';//不显示提示信息
		flag_email=true;	
	}
}
//验证提示问题答案
function checkQuestion(str_q,str_a){
	if(str_q!="" && str_a==""){//当密码提示问题不为空，而提示问题答案为空时
		document.getElementById("div_answer").innerHTML="请输入提示问题答案！";//设置提示信息
		document.getElementById("tr_answer").style.display='block';		//显示提示信息
		flag_answer=false;
	}else if(str_q=="" && str_a !=""){//当密码提示问题为空，而提示问题答案不为空时
		document.getElementById("div_question").innerHTML="请输入密码提示问题！";//设置提示信息
		document.getElementById("tr_question").style.display='block';	//显示提示信息
		flag_question=false;
	}else{
		document.getElementById("div_answer").innerHTML="";//清空提示信息
		document.getElementById("div_question").innerHTML="";//清空提示信息
		document.getElementById("tr_answer").style.display='none';	//不显示提示信息
		document.getElementById("tr_question").style.display='none';//不显示提示信息
		flag_answer=true;
		flag_question=true;
	}
}
</script>
<script language="javascript">
//保存用户注册信息
function save(){
	if(form1.user.value==""){		//当用户名为空时
		alert("请输入用户名！");form1.user.focus();return;
	}
	if(form1.pwd.value==""){		//当密码为空时
		alert("请输入密码！");form1.pwd.focus();return;
	}
	if(form1.repwd.value==""){		//当没有输入确认密码时
		alert("请确认密码！");form1.repwd.focus();return;
	}
	if(form1.email.value==""){		//当E-mail地址为空时
		alert("请输入E-mail地址！");form1.email.focus();return;
	}
	if(flag_user && flag_pwd && flag_repwd && flag_email && flag_question && flag_answer){	//所有数据都符合要求时
		var param="user="+form1.user.value+"&pwd="+form1.pwd.value+"&email="+form1.email.value+"&question="+
		form1.question.value+"&answer="+form1.answer.value+"&city="+form1.city.value; 		//组合参数
		var loader=new net.AjaxRequest("UserServlet?action=save&nocache="+new Date().getTime(),deal_save,onerror,"POST",param);
	}else{
		alert("您填写的注册信息不合法，请确认！");
	}
}
function deal_save(){
	alert(this.req.responseText);		//弹出提示信息
	form_reset(form1);		//重置表单
	Myclose("register");	//隐藏用户注册页面
	
}
/*************************************************************************************************************/
//获取省份
function getProvince(){
	var loader=new net.AjaxRequest("UserServlet?action=getProvince&nocache="+new Date().getTime(),deal_getProvince,onerror,"GET");
}
function deal_getProvince(){
	provinceArr=this.req.responseText.split(",");//分割字符串
	for(i=0;i<provinceArr.length;i++){//设置下拉列表框的列表项
		document.getElementById("province").options[i]=new Option(provinceArr[i],provinceArr[i]);
	}
	if(provinceArr[0]!=""){
		getCity(provinceArr[0]);	//获取市县
	}
}
/*************************************************************************************************************/
//获取市县
function getCity(selProvince){
	var loader=new net.AjaxRequest("UserServlet?action=getCity&parProvince="+selProvince+"&nocache="+new Date().getTime(),deal_getCity,onerror,"GET");
}
function deal_getCity(){
	cityArr=this.req.responseText.split(",");//分割字符串
	document.getElementById("city").length=0;	//清空下拉列表
	for(i=0;i<cityArr.length;i++){//设置下拉列表框的列表项
		document.getElementById("city").options[i]=new Option(cityArr[i],cityArr[i]);
	}
}
/*************************************************************************************************************/
/*************************************************************************************************************/
function onerror(){		//错误处理函数
	alert("出错了");
}
//重置表单函数
function form_reset(form){
	form.reset();		//重置表单
	getProvince();		//获取省和直辖市
	document.getElementById("tr_user").style.display='none';
	document.getElementById("tr_pwd").style.display='none';
	document.getElementById("tr_email").style.display='none';
	document.getElementById("tr_question").style.display='none';
	document.getElementById("tr_answer").style.display='none';
}
</script>

  <div id="register" style="width:663; height:421; background-color:#546B51; padding:4px; position:absolute; z-index:11;display:none;">
  <form name="form1" action="" method="post">
    <table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#FEFEFC">
      <tr>
        <td height="408" align="center" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td height="50" style="color:#1B7F5D;font-size: 14px;"><b>清爽夏日九宫格日记网--用户注册</b></td>
          </tr>
        </table>
          <table width="94%" height="331" border="0" cellpadding="0" cellspacing="1" bgcolor="#CCCCCC">
            <tr>
              <td height="310" valign="top" bgcolor="#FFFFFF"><table border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFEF9">
                <tr id="tr_user" style="display:none">
                  <td height="40" colspan="2" align="center"><div id="div_user" style="border:#FF6600 1px solid; color:#FF0000; width:90%; height:29px; padding-top:8px;"></div></td>
                </tr>
                <tr>
                  <td width="93" height="40" align="right">用户名：</td>
                  <td height="40" align="left"><input name="user" type="text" onBlur="checkUser(this.value)">
                    &nbsp;*长度限制为20个字母或10个汉字</td>
                </tr>
                <tr id="tr_pwd" style="display:none">
                  <td height="40" colspan="2" align="center"><div id="div_pwd" style="border:#FF6600 1px solid; color:#FF0000; width:90%; height:29px; padding-top:8px; background-image:url(images/div_bg.jpg)"></div></td>
                </tr>
                <tr>
                  <td height="40" align="right">密码：</td>
                  <td height="40" align="left"><input name="pwd" type="password" onBlur="checkPwd(this.value)">
                    &nbsp;* 密码由字母开头的字母、数字或下划线组成，并且密码的长度大于6位小于30位</td>
                </tr>
                <tr>
                  <td height="40" align="right">确认密码：</td>
                  <td height="40" align="left"><input name="repwd" type="password" onBlur="checkRepwd(this.value)">
                    &nbsp;* 请确认密码 </td>
                </tr>
                <tr id="tr_email" style="display:none">
                  <td height="40" colspan="2" align="center"><div id="div_email" style="border:#FF6600 1px solid; color:#FF0000; width:90%; height:29px; padding-top:8px; background-image:url(images/div_bg.jpg)"></div></td>
                </tr>
                <tr>
                  <td height="40" align="right">E-mail地址：</td>
                  <td height="40" align="left"><input name="email" type="text" size="35" onBlur="checkEmail(this.value)">
                    &nbsp;* 请输入有效的E-mail地址，在找回密码时应用 </td>
                </tr>
                <tr>
                  <td height="40" align="right">所在地：</td>
                  <td height="40" align="left"><select name="province" id="province" onChange="getCity(this.value)">
                  </select>
                  -
                  <select name="city" id="city">
                      </select></td>
                </tr>
                <tr>
                  <td height="40" colspan="2" align="center">以下两个选项，只要有任何一个没有输入，将不可以通过答案问题重新设置密码。</td>
                </tr>
                <tr id="tr_question" style="display:none">
                  <td height="40" colspan="2" align="center"><div id="div_question" style="border:#FF6600 1px solid; color:#FF0000; width:90%; height:29px; padding-top:8px; background-image:url(images/div_bg.jpg)"></div></td>
                </tr>
                <tr>
                  <td height="40" align="right">密码提示问题：</td>
                  <td height="40" align="left"><input name="question" type="text" id="question" size="35" onBlur="checkQuestion(this.value,this.form.answer.value)">
                    如：我的工作单位</td>
                </tr>
                <tr id="tr_answer" style="display:none">
                  <td height="40" colspan="2" align="center"><div id="div_answer" style="border:#FF6600 1px solid; color:#FF0000; width:90%; height:29px; padding-top:8px; background-image:url(images/div_bg.jpg)"></div></td>
                </tr>
                <tr>
                  <td height="40" align="right">提示问题答案：</td>
                  <td height="40" align="left"><input name="answer" type="text" id="answer" size="35" onBlur="checkQuestion(this.form.question.value,this.value)">
 如：明日科技                  </td>
                </tr>
                <tr>
                  <td height="40">&nbsp;</td>
                  <td height="40" align="center"><input name="btn_sumbit" type="button" class="btn_grey" value="提交" onClick="save()">
                    &nbsp;
                    <input name="btn_reset" type="button" class="btn_grey" value="重置" onClick="form_reset(this.form)">
					&nbsp;
                    <input name="btn_close" type="button" class="btn_grey" value="关闭" onClick="Myclose('register')"></td>
                </tr>

              </table></td>
            </tr>
          </table></td>
      </tr>
      <tr>
        <td height="10" align="center" valign="top" bgcolor="#FEFEFC">&nbsp;</td>
      </tr>
    </table>
	</form>
  </div>