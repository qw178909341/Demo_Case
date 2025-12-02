package com.fishs.chat16_design.creational.singleton.pkg;

/**
 * @Description:
 * @Author: lf
 * @Date: 2025/12/2 15:21
 */
public class Student
{
    private static Student instance;
    private Student(){}
    private String name;
    private Integer age;
    public void setName(String name)
    {
        this.name = name;
    }
    public void setAge(Integer age)
    {
        this.age = age;
    }
    public static Student getInstance()
    {
        if(instance == null)
        {
            instance = new Student();
        }
        return instance;
    }
    public String toString(){
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
