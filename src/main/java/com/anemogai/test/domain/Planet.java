package com.anemogai.test.domain;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "planets")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Planet  {

    @Id
    @Column(name = "planet_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer planetId;

    @Column(name = "planet_name")
    private String planetName;

    @ManyToOne
    @JoinColumn(name = "overlord_id")
    private Overlord overlord;

    public Planet(String planetName) {
        this.planetName = planetName;
    }
}
