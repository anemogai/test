package com.anemogai.test.repo;

import com.anemogai.test.domain.Overlord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OverlordsRepository extends JpaRepository<Overlord, Integer> {
}
