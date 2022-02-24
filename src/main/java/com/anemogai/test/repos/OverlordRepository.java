package com.anemogai.test.repos;

import com.anemogai.test.domain.Overlord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OverlordRepository extends JpaRepository<Overlord, Integer> {
    boolean existsOverlordById(Integer overlordId);
    Overlord findOverlordById(Integer overlordId);

    @Query("SELECT DISTINCT overlord FROM Overlord overlord LEFT JOIN Planet planet ON (overlord.id = planet.overlord.id) WHERE planet.overlord.id IS NULL")
    List<Overlord> findAllBums();

    List<Overlord> findTop3ByOrderByAge();
}
