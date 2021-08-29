package com.testTask.TestTask.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/greeting")
    public String greeting( Model model) {
        model.addAttribute("title", "Главная страница");
        return "greeting";
    }

}