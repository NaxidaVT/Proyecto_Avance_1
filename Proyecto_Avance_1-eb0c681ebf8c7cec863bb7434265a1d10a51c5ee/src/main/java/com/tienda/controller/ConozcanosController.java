package com.tienda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/conozcanos")
public class ConozcanosController {

    @GetMapping("/listado")
    public String listado() {
        return "/conozcanos/listado";
    }

    @GetMapping("/nuevo")
    public String conozcanosNuevo() {
        return "/conozcanos/modifica";
    }

    @GetMapping("/modificar/{idConozcanos}")
    public String conozcanosModificar() {
        return "/conozcanos/modifica";
    }
}
