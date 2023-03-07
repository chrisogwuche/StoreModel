package com.decagon.entity;

import com.decagon.enums.Gender;

abstract class Users {
    private String name;
    private String id;
    private int age;
    private Gender gender;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Users(){}
    public Users(String id,String name,int age, Gender gender){
        this.name = name;
        this.id = id;
        this.age = age;
        this.gender = gender;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Users{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}
