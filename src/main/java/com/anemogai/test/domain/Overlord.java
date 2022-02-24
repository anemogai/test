package com.anemogai.test.domain;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "overlords")
@Data
public class Overlord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

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
}
