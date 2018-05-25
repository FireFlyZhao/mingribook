function countdown(title,Intime,divId){
var online= new Date(Intime);
var now = new Date();
var leave = online.getTime() - now.getTime();
var day = Math.floor(leave / (1000 * 60 * 60 * 24))+1;
if (day > 1){ 
	 	if(document.all){
			divId.innerHTML="<b>——距"+ title+"还有"+day +"天！</b>";
		}
}else{
	 if (day == 1) {
	 	if(document.all){
			divId.innerHTML="<b>——明天就是"+title+"啦!</b>";
		}
	 	
	}else{
		 if (day == 0) {divId.innerHTML="<b>今天就是"+title+"呀！</b>";
		 }else{
			 if(document.all){
				divId.innerHTML="<b>——唉呀！"+title+"已经过了！</b>";
			 }
		}
	}
}
}
