package com.mr.user;

public class User {
    
    private String name;//�û�����
    private Integer age;//����
    private String sex;//�Ա�
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    //���JavaBean������ֵ����
    public void printInfo(){
        System.out.println("�û���������"+name);//����û�������
        System.out.println("�û����䡪��"+age);//����û�������
        System.out.println("�û��Ա𡪡�"+sex);//����û����Ա�
    }
}
