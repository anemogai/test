package com.anemogai.test.services.impl;

import com.anemogai.test.domain.Overlord;
import com.anemogai.test.domain.Planet;
import com.anemogai.test.repos.OverlordRepository;
import com.anemogai.test.services.OverlordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OverlordServiceImpl implements OverlordService {

    @Autowired
    private OverlordRepository overlordRepository;

    @Override
    public List<Overlord> getAll() {
        return overlordRepository.findAll();
    }

    @Override
    public Overlord overlordAdd(Overlord overlord) {
        return overlordRepository.save(overlord);
    }

}
