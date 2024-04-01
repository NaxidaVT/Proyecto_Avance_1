package com.tienda.controller;

import com.tienda.domain.Inicio;
import com.tienda.service.InicioService;
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
@RequestMapping("/inicio")
public class InicioController {

    @Autowired
    private InicioService inicioService;

    @GetMapping("/listado")
    private String listado(Model model) {
        var inicios = inicioService.getInicio(false);
        model.addAttribute("inicios", inicios);
        model.addAttribute("totalInicio", inicios.size());
        return "/inicio/listado";
    }

    @GetMapping("/nuevo")
    public String inicioNuevo(Inicio inicio) {
        return "/inicio/modifica";
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

    @PostMapping("/guardar")
    public String inicioGuardar(Inicio inicio,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            inicioService.save(inicio);
            inicio.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile,
                            "inicio",
                            inicio.getIdInicio()));
        }
        inicioService.save(inicio);
        return "redirect:/inicio/listado";
    }

    @GetMapping("/eliminar/{idInicio}")
    public String inicioEliminar(Inicio inicio) {
        inicioService.delete(inicio);
        return "redirect:/inicio/listado";
    }

    @GetMapping("/modificar/{idInicio}")
    public String inicioModificar(Inicio inicio, Model model) {
        inicio = inicioService.getInicio(inicio);
        model.addAttribute("inicio", inicio);
        return "/inicio/modifica";
    }
}
