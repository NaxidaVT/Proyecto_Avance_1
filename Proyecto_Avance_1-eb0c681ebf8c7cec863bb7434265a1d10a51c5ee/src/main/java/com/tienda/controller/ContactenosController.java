package com.tienda.controller;

import com.tienda.domain.Contactenos;
import com.tienda.service.ContactenosService;
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
@RequestMapping("/contactenos")
public class ContactenosController {

    @Autowired
    private ContactenosService contactenosService;

    @GetMapping("/listado")
    private String listado(Model model) {
        var contactenos = contactenosService.getContactenos(false);
        model.addAttribute("contactenos", contactenos);
        model.addAttribute("totalContactenoss", contactenos.size());
        return "/contactenos/listado";
    }

    @GetMapping("/nuevo")
    public String contactenosNuevo(Contactenos contactenos) {
        return "/contactenos/modifica";
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

    @PostMapping("/guardar")
    public String contactenosGuardar(Contactenos contactenos,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            contactenosService.save(contactenos);
            contactenos.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile,
                            "contactenos",
                            contactenos.getIdContactenos()));
        }
        contactenosService.save(contactenos);
        return "redirect:/contactenos/listado";
    }

    @GetMapping("/eliminar/{idContactenos}")
    public String contactenosEliminar(Contactenos contactenos) {
        contactenosService.delete(contactenos);
        return "redirect:/contactenos/listado";
    }

    @GetMapping("/modificar/{idContactenos}")
    public String contactenosModificar(Contactenos contactenos, Model model) {
        contactenos = contactenosService.getContactenos(contactenos);
        model.addAttribute("contactenos", contactenos);
        return "/contactenos/modifica";
    }
}
