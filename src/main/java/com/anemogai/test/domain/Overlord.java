package com.anemogai.test.domain;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

@Entity
@Table(name = "overlords")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Overlord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    private Integer age;

    @OneToMany(mappedBy = "overlord", fetch = FetchType.LAZY)
    private List<Planet> planetList = new ArrayList<>();


    public Overlord(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
