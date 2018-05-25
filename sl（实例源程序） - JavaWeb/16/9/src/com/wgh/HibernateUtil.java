package com.wgh;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.wgh.model.TbMessage;


/**
 * Configures and provides access to Hibernate sessions, tied to the
 * current thread of execution.  Follows the Thread Local Session
 * pattern, see {@link http://hibernate.org/42.html }.
 */
public class HibernateUtil {

    static SessionFactory sessionFactory;
    private Session session=null;
    private Transaction tx =null;
    //��ʼ��Hibernate,����SessionFactoryʵ��,ֻ�ڸ��౻���ص��ڴ�ʱִ��һ��
    static{
        try{
           Configuration config = new Configuration().configure();
            //config.addClass(TbMessage.class);
            sessionFactory = config.buildSessionFactory();
        } catch (Exception e) {
            System.out.println("static���У�"+e.getMessage());
        }
    }
    //����session
    public void openSession() {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();//��������
    }
    //��ȡ������Ϣ�б�
    public List<TbMessage> listMessage(){
	    	openSession();//����session
	    	 String hql="FROM TbMessage m ORDER BY m.sendTime DESC";	//�����ѯȫ��������Ϣ
	         List<TbMessage> list=null;
	         try{
	             Query query=session.createQuery(hql);
	             list=(List<TbMessage>)query.list();
	         }catch(Exception e){
	             System.out.println("��ѯʱ�Ĵ�����Ϣ��"+e.getMessage());
	         }finally{
	             session.close();
	         }
	         return list;

    }
    //��ȡָ��������Ϣ
    public TbMessage getMessage(int id){
    	openSession();//����session
    	TbMessage tbMessage=(TbMessage)session.get(TbMessage.class, id);//ͨ��get������ѯָ��ID��������Ϣ
    	session.close();	//�ر�session
    	return tbMessage;
    }
    
    //�޸�������Ϣ
    public String updateMessage(TbMessage message){
    	try{
	    	openSession();//����session
	    	//��Ӧ��update()����ʱ��Ӧ���ȵ���get()�����������ݣ�Ȼ���ٵ���update()������������
	    	TbMessage m=(TbMessage)session.get(TbMessage.class,message.getId());
	    	m.setWriter(message.getWriter());
	    	m.setContent(message.getContent());
	    	session.update(m);//Ӧ��update()�����޸�������Ϣ�����ݿ�
	    	tx.commit();     //�ύ����
	    	closeSession();//�ر�session
	    	return "������Ϣ�޸ĳɹ���";
    	}catch(Exception e){
    		e.printStackTrace();
    		tx.rollback();//����ع�
    		
    		return "�޸�������Ϣʧ�ܣ�";
    	}
    }
    //�ر�session
    public void closeSession() {
        session.close();
    }
    
}