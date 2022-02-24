package com.anemogai.test.controllers;

import com.anemogai.test.domain.Overlord;
import com.anemogai.test.domain.Planet;
import com.anemogai.test.services.impl.OverlordServiceImpl;
import com.anemogai.test.services.impl.PlanetServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/planets")
public class PlanetController {

    @Autowired
    private PlanetServiceImpl planetService;

    @Autowired
    private OverlordServiceImpl overlordService;

    @GetMapping("/allPlanets")
    public String allPlanets(Model model){
        Iterable<Planet> planets = planetService.getAll();
        model.addAttribute("planets", planets);
        return "all/all_planets";
    }

    @GetMapping("/destroyPlanet")
    public String destroyPlanet(){
        return "destroy/destroy_planet";
    }

    @PostMapping("/destroyPlanet")
    public String destroyPlanetPost(@RequestParam String planetName){
        if(!planetService.existsPlanet(planetName)){
            return "redirect:/planets/allPlanets";
        }
        Planet planet = planetService.getByName(planetName);
        planetService.deletePlanet(planet);
        return "redirect:/planets/allPlanets";
    }

    @GetMapping("/addPlanet")
    public String addPlanet(){
        return "add/add_planet";
    }

    @PostMapping("/addPlanet")
    public String addPlanetPost(@RequestParam String planetName){
        Planet planet = new Planet(planetName);
        planetService.planetAdd(planet);
        return "redirect:/planets/allPlanets";
    }

    @GetMapping("/appointOverlord")
    public String appoint(){
        return "appoint/appoint_overlord";
    }


    @PostMapping("/appointOverlord")
    public String appointOverlord(@RequestParam String planetName, @RequestParam Integer overlordId){
        if(!(overlordService.existsOverlord(overlordId) || planetService.existsPlanet(planetName))) {
            return "redirect:/planets/allPlanets";
        }
        Planet planet = planetService.getByName(planetName);
        Overlord overlord = overlordService.getById(overlordId);

        planet.setOverlord(overlord);
        planetService.planetAdd(planet);

        return "redirect:/planets/allPlanets";
    }


}
