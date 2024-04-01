package com.tienda.controller;

import com.tienda.domain.Conozcanos;
import com.tienda.service.ConozcanosService;
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
@RequestMapping("/conozcanos")
public class ConozcanosController {

    @Autowired
    private ConozcanosService conozcanosService;

    @GetMapping("/listado")
    private String listado(Model model) {
        var conozcanos = conozcanosService.getConozcanos(false);
        model.addAttribute("conozcanos", conozcanos);
        model.addAttribute("totalConozcanos", conozcanos.size());
        return "/conozcanos/listado";
    }

    @GetMapping("/nuevo")
    public String conozcanosNuevo(Conozcanos conozcanos) {
        return "/conozcanos/modifica";
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

    @PostMapping("/guardar")
    public String conozcanosGuardar(Conozcanos conozcanos,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            conozcanosService.save(conozcanos);
            conozcanos.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile,
                            "conozcanos",
                            conozcanos.getIdConozcanos()));
        }
        conozcanosService.save(conozcanos);
        return "redirect:/conozcanos/listado";
    }

    @GetMapping("/eliminar/{idConozcanos}")
    public String conozcanosEliminar(Conozcanos conozcanos) {
        conozcanosService.delete(conozcanos);
        return "redirect:/conozcanos/listado";
    }

    @GetMapping("/modificar/{idConozcanos}")
    public String conozcanosModificar(Conozcanos conozcanos, Model model) {
        conozcanos = conozcanosService.getConozcanos(conozcanos);
        model.addAttribute("conozcanos", conozcanos);
        return "/conozcanos/modifica";
    }
}
