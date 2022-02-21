package com.anemogai.test.controllers;

import com.anemogai.test.domain.Overlord;
import com.anemogai.test.domain.Planet;
import com.anemogai.test.repo.OverlordsRepository;
import com.anemogai.test.repo.PlanetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/overlords")
public class OverlordController {

    @Autowired
    private OverlordsRepository overlordsRepository;

    @GetMapping("/allOverlords")
    public String allLords(Model model){
        Iterable<Overlord> overlords = overlordsRepository.findAll();
        model.addAttribute("overlords", overlords);
        return "all_overlords";
    }

}
