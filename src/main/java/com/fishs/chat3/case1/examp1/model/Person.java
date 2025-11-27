package com.fishs.chat3.case1.examp1.model;

/**
 * @Description:
 * @Author: lf
 * @Date: 2025/11/12 14:12
 */

public final class Person extends Base {
    private String name;
    private Integer age;
    private String gender;

    public Person() {

    }

    public Person(String name, Integer age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        if (age == null || age < 0 || age > 120) {
            System.out.println("年龄不合法");
        }
        this.age = age;
    }

    public void SayText(String text) {
        System.out.println(this.name + "说：" + text);
    }

    public void SayText(String name, String text) {
        System.out.println(name + "说：" + text);
    }

    public String toString() {
        System.out.println("version:" + getVersion());
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

    public void setVersion(String version) {
        super.setVersion(version + "重写！");
    }
}
