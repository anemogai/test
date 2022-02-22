package com.anemogai.test.controllers;

import com.anemogai.test.domain.Planet;
import com.anemogai.test.repo.PlanetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/destroyPlanet")
    public String destroyPlanetPost(@RequestParam String planet_name, Model model){
        Planet planet = new Planet();
        return "";
    }

    @GetMapping("/addPlanet")
    public String addPlanet(){
        return "add_planet";
    }

    @PostMapping("/addPlanet")
    public String addPlanetPost(@RequestParam String planet_name){
        Planet planet = new Planet(planet_name, null);
        planetsRepository.save(planet);
        return "redirect:/planets/allPlanets";
    }



}
