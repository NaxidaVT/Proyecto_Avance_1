package com.tienda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PoliticaController {

    
    @GetMapping("/politica")
    public String mostrarPolitica() {
     
        return "politicas/politica";
    }
}