package com.example.homeworkmodule16.entity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    // Для Thymeleaf
    @GetMapping("/test")
    public String test(Model model) {
        model.addAttribute("message", "Hello, World from Thymeleaf!");
        return "test"; // ім'я шаблону test.html
    }

    // Для простого текстового тесту
    @GetMapping("/ping")
    public String ping() {
        return "App is working!";
    }
}
