<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<html>
  <head>
    <title>���������б�</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<script language="javascript" src="JS/AjaxRequest.js"></script>
<script language="javascript">
//��ȡʡ�ݺ�ֱϽ��
function getProvince(){
	var loader=new net.AjaxRequest("ZoneServlet?action=getProvince&nocache="+new Date().getTime(),deal_getProvince,onerror,"GET");
}
function deal_getProvince(){
	provinceArr=this.req.responseText.split(",");	//����ȡ��ʡ�������ַ����ָ�Ϊ����
	
	for(i=0;i<provinceArr.length;i++){		//ͨ��ѭ���������е�ʡ��������ӵ������б���
		document.getElementById("province").options[i]=new Option(provinceArr[i],provinceArr[i]);
	}
	if(provinceArr[0]!=""){
		getCity(provinceArr[0]);	//��ȡ����
	}
}
window.onload=function(){
	 getProvince();		//��ȡʡ�ݺ�ֱϽ��
}
/*************************************************************************************************************/
//��ȡ����
function getCity(selProvince){
	var loader=new net.AjaxRequest("ZoneServlet?action=getCity&parProvince="+selProvince+"&nocache="+new Date().getTime(),deal_getCity,onerror,"GET");
}
function deal_getCity(){
	cityArr=this.req.responseText.split(",");	//����ȡ�����������ַ����ָ�Ϊ����
	document.getElementById("city").length=0;	//��������б�
	for(i=0;i<cityArr.length;i++){		//ͨ��ѭ���������е�����������ӵ������б���
		document.getElementById("city").options[i]=new Option(cityArr[i],cityArr[i]);
	}
}
function onerror(){}		//��������
</script>
  </head>
  
  <body style="font-size: 9pt;">
  ��ѡ��
	  <select name="province" id="province" onChange="getCity(this.value)">
      </select>
      -
	  <select name="city" id="city">
	  </select>
  </body>
</html>
