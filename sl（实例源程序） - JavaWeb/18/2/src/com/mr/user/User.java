package com.mr.user;

public class User {
    
    private String name;//用户姓名
    private Integer age;//年龄
    private String sex;//性别
    //构造方法
    public User(String name,Integer age,String sex){
        this.name=name;
        this.age=age;
        this.sex=sex;
    }
    //输出JavaBean的属性值方法
    public void printInfo(){
        System.out.println("用户姓名——"+name);//输出用户的姓名
        System.out.println("用户年龄——"+age);//输出用户的年龄
        System.out.println("用户性别——"+sex);//输出用户的性别
    }
}
