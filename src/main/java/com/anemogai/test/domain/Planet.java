package com.anemogai.test.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "planets")
@Data
public class Planet  {

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

}
