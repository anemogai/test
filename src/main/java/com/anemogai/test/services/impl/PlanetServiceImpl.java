package com.anemogai.test.services.impl;

import com.anemogai.test.domain.Planet;
import com.anemogai.test.repos.PlanetRepository;
import com.anemogai.test.services.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanetServiceImpl implements PlanetService {

    @Autowired
    private PlanetRepository planetRepository;

    @Override
    public Planet getByName(String planetName) {
        return planetRepository.findByPlanetName(planetName);
    }

    @Override
    public boolean existsPlanet(String planetName) {
        return planetRepository.existsPlanetByPlanetName(planetName);
    }

    @Override
    public List<Planet> getAll() {
        return planetRepository.findAll();
    }

    @Override
    public void deletePlanet(Planet planet) {
        planetRepository.delete(planet);
    }

    @Override
    public Planet planetAdd(Planet planet) {
        return planetRepository.save(planet);
    }


}
