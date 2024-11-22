package br.com.gs.Energy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String home() {
        return "index"; // Retorna o nome do template Thymeleaf
    }
}
