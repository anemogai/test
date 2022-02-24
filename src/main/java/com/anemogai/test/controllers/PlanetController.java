package com.anemogai.test.controllers;

import com.anemogai.test.domain.Planet;
import com.anemogai.test.repos.OverlordRepository;
import com.anemogai.test.repos.PlanetRepository;
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
    private OverlordRepository overlordRepository;

    @GetMapping("/allPlanets")
    public String allLords(Model model){
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
        Planet planet = new Planet(planetName, null);
        planetService.planetAdd(planet);
        return "redirect:/planets/allPlanets";
    }

    @GetMapping("/appointOverlord")
    public String appoint(){
        return "appoint/appoint_overlord";
    }

    /*
    @PostMapping("/appointOverlord")
    public String appointOverlord(@RequestParam String planetName, @RequestParam Integer overlordId){
        if(!(planetRepository.existsPlanetByPlanetName(planetName) && overlordRepository.existsById(overlordId))){
            return "redirect:/planets/allPlanets";
        }
        Planet planet = planetRepository.findByPlanetName(planetName);
        planet.setOverlordId(overlordId);
        planetRepository.save(planet);
        return "redirect:/planets/allPlanets";
    }

     */

    @GetMapping("/findBums")
    public String findBums(Model model){
        /*
        if(!(planetsRepository.existsPlanetByPlanetName(planetName) && overlordsRepository.existsById(overlordId))){
            return "redirect:/planets/allPlanets";
        }
        Planet planet = planetsRepository.findByPlanetName(planetName);
        planet.setOverlordId(overlordId);
        planetsRepository.save(planet);

         */
        return "all/all_bums";
    }
}
