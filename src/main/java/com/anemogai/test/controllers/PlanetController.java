package com.anemogai.test.controllers;

import com.anemogai.test.domain.Planet;
import com.anemogai.test.repos.OverlordsRepository;
import com.anemogai.test.repos.PlanetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/planets")
public class PlanetController {

    @Autowired
    private PlanetsRepository planetsRepository;
    @Autowired
    private OverlordsRepository overlordsRepository;

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
    public String destroyPlanetPost(@RequestParam String planetName){
        if(!planetsRepository.existsPlanetByPlanetName(planetName)){
            return "redirect:/planets/allPlanets";
        }
        Planet planet = planetsRepository.findByPlanetName(planetName);
        planetsRepository.delete(planet);
        return "redirect:/planets/allPlanets";
    }

    @GetMapping("/addPlanet")
    public String addPlanet(){
        return "add_planet";
    }

    @PostMapping("/addPlanet")
    public String addPlanetPost(@RequestParam String planetName){
        Planet planet = new Planet(planetName, null);
        planetsRepository.save(planet);
        return "redirect:/planets/allPlanets";
    }

    @GetMapping("/appointOverlord")
    public String appoint(){
        return "appoint_overlord";
    }

    @PostMapping("/appointOverlord")
    public String appointOverlord(@RequestParam String planetName, @RequestParam Integer overlordId){
        if(!(planetsRepository.existsPlanetByPlanetName(planetName))){
            return "redirect:/planets/allPlanets";
        }
        Planet planet = planetsRepository.findByPlanetName(planetName);
        planet.setOverlordId(overlordId);
        planetsRepository.save(planet);
        return "redirect:/planets/allPlanets";
    }
}
