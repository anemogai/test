package com.anemogai.test.repo;

import com.anemogai.test.domain.Planet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanetsRepository extends JpaRepository<Planet, Integer> {
}
