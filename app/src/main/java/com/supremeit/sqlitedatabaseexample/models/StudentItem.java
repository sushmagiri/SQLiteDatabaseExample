package com.supremeit.sqlitedatabaseexample.models;

/**
 * Created by RuShma on 8/17/2016.
 */
public class StudentItem {
    int id ;
    String name, address,age;

    public StudentItem(int id, String name, String address, String age){
        this.id = id;
        this.name = name;
        this.address = address;
        this.age = age;
    }

    public StudentItem(String name, String address, String age){
        this.name = name;
        this.address = address;
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
