/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VillaGastronotiica.demo.controller;

import VillaGastronotiica.demo.domain.Restaurante;
import VillaGastronotiica.demo.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/restaurante")
public class RestaurantesController {
  
    @Autowired
    private RestauranteService restauranteService;
    

    @GetMapping("/listado")
    public String listado(Model model) {
        var restaurantes = restauranteService.getAllRestaurantes();
        model.addAttribute("restaurantes", restaurantes);
        return "/restaurante/listado";
    }

    @PostMapping("/guardar")
    public String restauranteGuardar(Restaurante restaurante,
            @RequestParam("imagenFile") MultipartFile imagenFile) {        
        if (!imagenFile.isEmpty()) {
        }
        restauranteService.saveRestaurante(restaurante);
        return "redirect:/restaurante/listado";
    }

    @GetMapping("/eliminar/{id}")
    public String restauranteEliminar(@RequestParam("id") Long id) {
        restauranteService.deleteRestaurante(id);
        return "redirect:/restaurante/listado";
    }

    @GetMapping("/modificar/{id}")
    public String restauranteModificar(@RequestParam("id") Long id, Model model) {
        Restaurante restaurante = restauranteService.getRestauranteById(id);
        model.addAttribute("restaurante", restaurante);
        return "/restaurante/modifica";
    }   
}