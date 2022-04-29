package com.paloma.MVCMudi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HeloController {

    @GetMapping("/hello")
    public String hello(Model model){
        model.addAttribute("nome", "Paloma");
        return "hello";
    }
}
