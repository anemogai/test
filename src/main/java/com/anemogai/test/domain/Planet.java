package com.anemogai.test.domain;

import javax.persistence.*;

@Entity
@Table(name = "planets")
public class Planet {

    @Id
    @Column(name = "planet_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int planet_id;

    @Column(name = "planet_name")
    private String planet_name;
    @Column(name = "overlord_id")
    private Integer overlord_id;

    public Planet() {
    }

    public Planet(String planet_name) {
        this.planet_name = planet_name;
    }

    public Planet(String planet_name, int overlord_id) {
        this.planet_name = planet_name;
        this.overlord_id = overlord_id;
    }

    public Planet(int planet_id, String planet_name, Integer overlord_id) {
        this.planet_id = planet_id;
        this.planet_name = planet_name;
        this.overlord_id = overlord_id;
    }

    public Integer getPlanet_id() {
        return planet_id;
    }

    public void setPlanet_id(Integer planet_id) {
        this.planet_id = planet_id;
    }

    public String getPlanet_name() {
        return planet_name;
    }

    public void setPlanet_name(String planet_name) {
        this.planet_name = planet_name;
    }

    public Integer getOverlord_id() {
        return overlord_id;
    }

    public void setOverlord_id(Integer overlord_id) {
        this.overlord_id = overlord_id;
    }
}
