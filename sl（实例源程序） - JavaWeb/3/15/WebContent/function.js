function countdown(title,Intime,divId){
var online= new Date(Intime);
var now = new Date();
var leave = online.getTime() - now.getTime();
var day = Math.floor(leave / (1000 * 60 * 60 * 24))+1;
if (day > 1){ 
	 	if(document.all){
			divId.innerHTML="<b>������"+ title+"����"+day +"�죡</b>";
		}
}else{
	 if (day == 1) {
	 	if(document.all){
			divId.innerHTML="<b>�����������"+title+"��!</b>";
		}
	 	
	}else{
		 if (day == 0) {divId.innerHTML="<b>�������"+title+"ѽ��</b>";
		 }else{
			 if(document.all){
				divId.innerHTML="<b>������ѽ��"+title+"�Ѿ����ˣ�</b>";
			 }
		}
	}
}
}
