package com.anemogai.test.repos;

import com.anemogai.test.domain.Overlord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OverlordRepository extends JpaRepository<Overlord, Integer> {
    boolean existsById(Integer overlordId);
}
