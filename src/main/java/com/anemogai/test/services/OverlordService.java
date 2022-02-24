package com.anemogai.test.services;

import com.anemogai.test.domain.Overlord;
import com.anemogai.test.domain.Planet;

import java.util.List;

public interface OverlordService {
    List<Overlord> getAll();
    Overlord overlordAdd(Overlord overlord);
}
