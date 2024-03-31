/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package VillaGastronotiica.demo.service;

import VillaGastronotiica.demo.domain.Comida;
import java.util.List;

public interface ComidaService {
    List<Comida> getAllComida();
    
    Comida getComidaById(Long id); 
    
    void saveComida(Comida comida);
    
    void deleteComida(Long id);
    
    List<Comida> getComidas(boolean activo);

    Comida getComida(Long id);

    List<Comida> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);

    List<Comida> metodoJPQL(double precioInf, double precioSup);

    List<Comida> metodoNativo(double precioInf, double precioSup);
}