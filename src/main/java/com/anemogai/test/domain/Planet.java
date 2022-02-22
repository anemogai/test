package com.anemogai.test.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "planets")
public class Planet {

    @Id
    @Column(name = "planet_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer planetId;

    @Column(name = "planet_name")
    private String planetName;
    @Column(name = "overlord_id")
    private Integer overlordId;

    public Planet() {
    }

    public Planet(String planetName) {
        this.planetName = planetName;
    }

    public Planet(String planetName, Integer overlordId) {
        this.planetName = planetName;
        this.overlordId = overlordId;
    }
    public Planet(Integer planetId, String planetName, Integer overlordId) {
        this.planetId = planetId;
        this.planetName = planetName;
        this.overlordId = overlordId;
    }

    public Integer getPlanetId() {
        return planetId;
    }

    public void setPlanetId(Integer planetId) {
        this.planetId = planetId;
    }

    public String getPlanetName() {
        return planetName;
    }

    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }

    public Integer getOverlordId() {
        return overlordId;
    }

    public void setOverlordId(Integer overlordId) {
        this.overlordId = overlordId;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "planetId=" + planetId +
                ", planetName='" + planetName + '\'' +
                ", overlordId=" + overlordId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Planet planet = (Planet) o;
        return Objects.equals(planetId, planet.planetId) && Objects.equals(planetName, planet.planetName) && Objects.equals(overlordId, planet.overlordId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(planetId, planetName, overlordId);
    }
}
