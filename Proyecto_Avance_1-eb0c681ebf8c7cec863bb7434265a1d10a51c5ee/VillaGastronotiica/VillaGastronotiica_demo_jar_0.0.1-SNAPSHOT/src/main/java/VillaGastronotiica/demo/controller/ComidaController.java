/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VillaGastronotiica.demo.controller;

import VillaGastronotiica.demo.domain.Comida;
import VillaGastronotiica.demo.service.ComidaService;
import VillaGastronotiica.demo.service.RestauranteService;
import VillaGastronotiica.demo.service.UsuarioService;
import VillaGastronotiica.demo.service.FavoritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/comida")
public class ComidaController {
    @Autowired
    private ComidaService comidaService;
    
    @Autowired
    private RestauranteService restauranteService;
    
    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private FavoritoService favoritosService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var comidas = comidaService.getAllComida();
        model.addAttribute("comidas", comidas);
        return "comida/listado";
    }

    @GetMapping("/nueva")
    public String nuevaComida(Model model) {
        model.addAttribute("restaurantes", restauranteService.getAllRestaurante());
        return "comida/modifica";
    }

    @PostMapping("/guardar")
    public String guardarComida(Comida comida, @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            // Aquí puedes procesar el archivo de imagen si es necesario
        }
        comidaService.saveComida(comida);
        return "redirect:/comida/listado";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarComida(@RequestParam("id") Long id) {
        comidaService.deleteComida(id);
        return "redirect:/comida/listado";
    }

    @GetMapping("/modificar/{id}")
    public String modificarComida(@RequestParam("id") Long id, Model model) {
        Comida comida = comidaService.getComidaById(id);
        model.addAttribute("comida", comida);
        model.addAttribute("restaurantes", restauranteService.getAllRestaurante());
        return "comida/modifica";
    }

    @PostMapping("/favorito")
    public String marcarFavorito(@RequestParam("usuarioId") Long usuarioId,
                                 @RequestParam("comidaId") Long comidaId,
                                 @RequestParam("restauranteId") Long restauranteId,
                                 @RequestParam("comentario") String comentario) {
        favoritosService.marcarFavorito(usuarioId, comidaId, restauranteId, comentario);
        return "redirect:/comida/listado";
    }
}