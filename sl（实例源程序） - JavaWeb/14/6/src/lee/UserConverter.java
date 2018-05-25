package lee;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.apache.struts2.util.StrutsTypeConverter;

/**
 * @author  yeeku.H.lee kongyeeku@163.com
 * @version  1.0
 * <br>Copyright (C), 2005-2008, yeeku.H.Lee
 * <br>This program is protected by copyright laws.
 * <br>Program Name:
 * <br>Date: 
 */
public class UserConverter extends StrutsTypeConverter 
{
	//ʵ�ֽ��ַ�������ת���ɸ������͵ķ���
    public Object convertFromString(Map context, String[] values, 
		Class toClass)
	{
		//����һ��Userʵ��
		 User user = new User();
		SimpleDateFormat format1=new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date1 = format1.parse(values[0]);
			SimpleDateFormat format2=new SimpleDateFormat("yyyy/MM/dd");
			String birthday=format2.format(date1);
			//ΪUserʵ����ֵ
			user.setDate(birthday);
			//����ת������Userʵ��		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
    }
    //ʵ�ֽ���������ת�����ַ������͵ķ���
    public String convertToString(Map context, Object o)
	{
		//����Ҫת����ֵǿ������ת��ΪUserʵ��
		User user = (User) o; 
		return "<" + user.getDate()+">";
    }
	
	

}