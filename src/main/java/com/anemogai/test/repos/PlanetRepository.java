package com.anemogai.test.repos;

import com.anemogai.test.domain.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetRepository extends JpaRepository<Planet, Integer> {

    Planet findByPlanetName(String planetName);
    boolean existsPlanetByPlanetName(String planetName);
}
