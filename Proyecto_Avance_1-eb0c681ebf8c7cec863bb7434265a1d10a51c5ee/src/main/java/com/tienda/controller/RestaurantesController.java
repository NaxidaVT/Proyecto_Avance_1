package com.tienda.controller;

import com.tienda.domain.Restaurantes;
import com.tienda.service.RestaurantesService;
import com.tienda.service.impl.FirebaseStorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/restaurantes")
public class RestaurantesController {

    @Autowired
    private RestaurantesService restaurantesService;

    @GetMapping("/listado")
    private String listado(Model model) {
        var restaurantes = restaurantesService.getRestaurantes(false);
        model.addAttribute("restaurantes", restaurantes);
        model.addAttribute("totalRestaurantes", restaurantes.size());
        return "/categoria/listado";
    }

    @GetMapping("/nuevo")
    public String restaurantesNuevo(Restaurantes restaurantes) {
        return "/restaurantes/modifica";
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

    @PostMapping("/guardar")
    public String restaurantesGuardar(Restaurantes restaurantes,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            restaurantesService.save(restaurantes);
            restaurantes.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile,
                            "restaurantes",
                            restaurantes.getIdRestaurante()));
        }
        restaurantesService.save(restaurantes);
        return "redirect:/restaurantes/listado";
    }

    @GetMapping("/eliminar/{idRestaurantes}")
    public String restaurantesEliminar(Restaurantes restaurantes) {
        restaurantesService.delete(restaurantes);
        return "redirect:/restaurantes/listado";
    }

    @GetMapping("/modificar/{idRestaurantes}")
    public String restaurantesModificar(Restaurantes restaurantes, Model model) {
        restaurantes = restaurantesService.getRestaurantes(restaurantes);
        model.addAttribute("restaurantes", restaurantes);
        return "/restaurantes/modifica";
    }
}
