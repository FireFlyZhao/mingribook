package com.mr.user;

public class PrintInfo {
    
    private User us;//ע��User����

    public User getUser() {
        return us;
    }

    public void setUser(User user) {
        this.us = user;
    }
    //��ӡ��User�����е�����
    public void PrintUser(){
        System.out.println("PrintInfo��ӡ��User����");
        System.out.println("----------------------");
        System.out.println("�û�����--"+us.getName());//����û�������
        System.out.println("�û�����--"+us.getAge());//����û�������
        System.out.println("�û��Ա�--"+us.getSex());//����û����Ա�
    }
}
