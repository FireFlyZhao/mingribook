package com.mr.user;

public class PrintInfo {
    
    private User user;//ע��User����

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    //��ӡ��User�����е�����
    public void PrintUser(){
        System.out.println("PrintInfo��ӡ��User����");
        System.out.println("----------------------");
        System.out.println("�û�����--"+user.getName());//����û�������
        System.out.println("�û�����--"+user.getAge());//����û�������
        System.out.println("�û��Ա�--"+user.getSex());//����û����Ա�
    }
}
