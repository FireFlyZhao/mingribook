package com.mr;

import java.util.Date;

public class UserInfo {
    private String name;//姓名
    private char sex;//性别
    private int age;//年龄
    private Date date;//出生日期
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public Date getDate() {
        return date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public char getSex() {
        return sex;
    }
    
    public void setSex(char sex) {
        this.sex = sex;
    }
    
    public void printInfo() {
        System.out.println("姓名：" + name + "\n性别：" + sex + "\n年龄：" + age
                + "\n出生日期：" + date.toLocaleString());
    }
}
