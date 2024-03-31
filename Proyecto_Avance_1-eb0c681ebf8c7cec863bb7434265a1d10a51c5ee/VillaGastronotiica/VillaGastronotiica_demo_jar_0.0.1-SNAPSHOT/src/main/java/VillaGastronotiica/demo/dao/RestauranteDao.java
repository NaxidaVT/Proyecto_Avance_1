/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package VillaGastronotiica.demo.dao;

/**
 *
 * @author EsteP
 */
import VillaGastronotiica.demo.domain.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestauranteDao extends JpaRepository<Restaurante, Long> {

}
