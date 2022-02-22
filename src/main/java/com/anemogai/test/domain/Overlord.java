package com.anemogai.test.domain;

import javax.persistence.*;

@Entity
@Table(name = "overlords")
public class Overlord {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private Integer age;

    public Overlord() {
    }

    public Overlord(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Overlord(int id, String name, int age) {
        this.id = id;
        this.name = name;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
