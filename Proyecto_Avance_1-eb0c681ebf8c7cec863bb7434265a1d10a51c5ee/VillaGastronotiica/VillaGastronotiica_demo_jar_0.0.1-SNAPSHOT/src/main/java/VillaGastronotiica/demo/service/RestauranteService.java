/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package VillaGastronotiica.demo.service;
import VillaGastronotiica.demo.domain.Restaurante;
import java.util.List;

public interface RestauranteService {
    List<Restaurante> getAllRestaurantes();
    
    void saveRestaurante(Restaurante restaurante);
    
    void deleteRestaurante(Long id);
    
    Restaurante getRestauranteById(Long id);
    List<Restaurante> getRestaurantes(boolean activo);

    Restaurante getRestaurante(Long id);
    public Object getAllRestaurante();
}