//判断输入的字符串是否大于指定长度
function checkstr(str,digit){ 
     var n=0;
     for(i=0;i<str.length;i++){
       var leg=str.charCodeAt(i);			//获取字符串中指定字符的Unicode编码
       if(leg>255){
             n+=2;
       }else {
             n+=1;
       }
     }
     if (n>digit){
       return true;
     }else {
      return false;
     } 
}
//判断用户名
function checkeUser(user){
	if(checkstr(user,20)){
		return false;
	}else{
		return true;	  
	}
}
//判断密码
function checkePwd(user){
	var str=user;
	 //在JavaScript中，正则表达式只能使用"/"开头和结束，不能使用双引号
	var Expression=/^[A-Za-z]{1}([A-Za-z0-9]|[._]){5,29}$/; 
	var objExp=new RegExp(Expression);		//创建正则表达式对象
	if(objExp.test(str)==true){				//通过正则表达式验证
		return true;
	}else{
		return false;
	}
}

//验证E-mail地址
function checkemail(email){
	var str=email;
	 //在JavaScript中，正则表达式只能使用"/"开头和结束，不能使用双引号
	var Expression=/\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/; 
	var objExp=new RegExp(Expression);		//创建正则表达式对象
	if(objExp.test(str)==true){				//通过正则表达式进行验证
		return true;
	}else{
		return false;
	}
}
