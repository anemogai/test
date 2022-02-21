package com.anemogai.test.controllers;

import com.anemogai.test.domain.Planet;
import com.anemogai.test.repo.PlanetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/planets")
public class PlanetController {

    @Autowired
    private PlanetsRepository planetsRepository;

    @GetMapping("/allPlanets")
    public String allLords(Model model){
        Iterable<Planet> planets = planetsRepository.findAll();
        model.addAttribute("planets", planets);
        return "all_planets";
    }

    @GetMapping("/destroyPlanet")
    public String destroyPlanet(){
        return "destroy_planet";
    }

    @GetMapping("/addPlanet")
    public String addPlanet(){
        return "add_planet";
    }



}
