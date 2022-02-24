package com.anemogai.test.controllers;

import com.anemogai.test.domain.Overlord;
import com.anemogai.test.repos.OverlordRepository;
import com.anemogai.test.services.impl.OverlordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/overlords")
public class OverlordController {

    @Autowired
    private OverlordServiceImpl overlordService;

    @GetMapping("/allOverlords")
    public String allLords(Model model){
        Iterable<Overlord> overlords = overlordService.getAll();
        model.addAttribute("overlords", overlords);
        return "all/all_overlords";
    }

    @GetMapping("/addOverlord")
    public String addPlanet(){
        return "add/add_overlord";
    }

    @PostMapping("/addOverlord")
    public String addPlanetPost(@RequestParam String name, @RequestParam Integer age){
        Overlord overlord = new Overlord(name, age);
        overlordService.overlordAdd(overlord);
        return "redirect:/overlords/allOverlords";
    }

    @GetMapping("/topOverlords")
    public String topOverlords(){
        return "top/top_overlords";
    }

}
