<%@ page language="java" pageEncoding="GBK"%>
<html>
<head>
<title>验证输入的日期格式是否正确</title>
<script language="javascript">
//判断输入的日期是否正确
function CheckDate(INDate){ 
if (INDate==""){return true;}
if(INDate.indexOf('-',0)!=-1){	separate="-"}
else{
	if(INDate.indexOf('/',0)!=-1){separate="/"}
	else {return true;}
	}
	area=INDate.indexOf(separate,0)
	//获取年份
	subYY=INDate.substr(0,area)
	if(isNaN(subYY) || subYY<=0){
		return true;
	}		
	//转换月份
	subMM=INDate.substr(area+1,INDate.indexOf(separate,area+1)-(area+1))
	if(isNaN(subMM) || subMM<=0){
		return true;
	}
	if(subMM.length<2){subMM="0"+subMM}
	//转换日
	area=INDate.lastIndexOf(separate)
	subDD=INDate.substr(area+1,INDate.length-area-1)
	if(isNaN(subDD) || subDD<=0){
		return true;
	}
	if(eval(subDD)<10){subDD="0"+eval(subDD)}
	NewDate=subYY+"-"+subMM+"-"+subDD
	if(NewDate.length!=10){return true;}
    if(NewDate.substr(4,1)!="-"){return true;}
    if(NewDate.substr(7,1)!="-"){return true;}
	var MM=NewDate.substr(5,2);
	var DD=NewDate.substr(8,2);
	if((subYY%4==0 && subYY%100!=0)||subYY%400==0){ //判断是否为闰年
		if(parseInt(MM)==2){
			if(DD>29){return true;}
		}
	}else{
		if(parseInt(MM)==2){
			if(DD>28){return true;}
		}	
	}
	var mm=new Array(1,3,5,7,8,10,12); //判断每月中的最大天数
	for(i=0;i< mm.length;i++){
		if (parseInt(MM) == mm[i]){
			if(parseInt(DD)>31){
				return true;
			}else{
				return false;
			}
		}
	}
   if(parseInt(DD)>30){return true;}
   if(parseInt(MM)>12){return true;}
   return false;
   }
</script>
<script language="javascript">
function check(myform){
	if(myform.sDate.value==""){
		alert("请输入日期");myform.sDate.focus();return;
	}		
	if(CheckDate(myform.sDate.value)){
		alert("您输入的日期不正确！\n 请注意日期格式（如：2007/07/17或2007-07-17）以及二月是否为闰年！");myform.sDate.focus();return;
	}
	if(!CheckDate(myform.sDate.value)){
		alert("您输入的日期是正确的！");
	}
	myform.submit();
}
</script>
</head>
<body>
	<form action="" method="post" name="form1">  
 <table width="98%" height="38"  border="0" cellpadding="0" cellspacing="0" >
  <input name="sDate" type="text" id="sDate">
<input name="Button" type="button" value="检测日期" onClick="check(form1)">
 


</body>
</html>
