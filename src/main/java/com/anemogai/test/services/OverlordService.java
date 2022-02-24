package com.anemogai.test.services;

import com.anemogai.test.domain.Overlord;
import com.anemogai.test.domain.Planet;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OverlordService {
    List<Overlord> getAll();
    Overlord overlordAdd(Overlord overlord);
    Overlord getById(Integer overlordId);
    boolean existsOverlord(Integer overlordId);
    List<Overlord> getBums();
    List<Overlord> getTopThree();
}
