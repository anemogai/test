package com.anemogai.test.services;

import com.anemogai.test.domain.Planet;

import java.util.List;

public interface PlanetService {
    Planet getByName(String planetName);
    boolean existsPlanet(String planetName);
    List<Planet> getAll();
    void deletePlanet(Planet planet);
    Planet planetAdd(Planet planet);

}
