package com.anemogai.test.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "planets")
public class Planet {

    @Id
    @Column(name = "planet_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer planet_id;

    @Column(name = "planet_name")
    private String planet_name;
    @Column(name = "overlord_id")
    private Integer overlord_id;

    public Planet() {
    }

    public Planet(String planet_name) {
        this.planet_name = planet_name;
    }

    public Planet(String planet_name, Integer overlord_id) {
        this.planet_name = planet_name;
        this.overlord_id = overlord_id;
    }

    public Planet(Integer planet_id, String planet_name, Integer overlord_id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Planet planet = (Planet) o;
        return Objects.equals(planet_id, planet.planet_id) && Objects.equals(planet_name, planet.planet_name) && Objects.equals(overlord_id, planet.overlord_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(planet_id, planet_name, overlord_id);
    }
}
