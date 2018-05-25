package com.mr.user;

public class User {
    
    private String name;//用户姓名
    private Integer age;//年龄
    private String sex;//性别
    
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

    //输出JavaBean的属性值方法
    public void printInfo(){
        System.out.println("用户姓名——"+name);//输出用户的姓名
        System.out.println("用户年龄——"+age);//输出用户的年龄
        System.out.println("用户性别——"+sex);//输出用户的性别
    }
}
