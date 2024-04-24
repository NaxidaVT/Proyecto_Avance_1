package com.tienda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/politicas")
public class PoliticasController {
    
    @GetMapping("/politicas/listado")
    public String mostrarPoliticas(Model model) {
 
        return "politicas"; 
    }
}