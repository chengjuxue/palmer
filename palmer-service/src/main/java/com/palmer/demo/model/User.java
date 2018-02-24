package com.palmer.demo.model;

/**
 * @Author: xuechengju
 * @Date: Created in 2017/7/26, at 下午9:26
 * @Modified by:
 * @Description:
 */
public class User {
    private Integer age;
    private String name;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId(){
        return Integer.valueOf(3);
    }
}
