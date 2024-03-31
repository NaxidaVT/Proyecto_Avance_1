/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package VillaGastronotiica.demo.dao;

/**
 *
 * @author EsteP
 */
import VillaGastronotiica.demo.domain.Comida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ComidaDao extends JpaRepository<Comida, Long> {

    List<Comida> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);

    @Query("SELECT c FROM Comida c WHERE c.precio BETWEEN :precioInf AND :precioSup ORDER BY c.descripcion ASC")
    List<Comida> metodoJPQL(@Param("precioInf") double precioInf, @Param("precioSup") double precioSup);

    @Query(nativeQuery = true,
            value = "SELECT * FROM Comidas WHERE Precio BETWEEN :precioInf AND :precioSup ORDER BY Descripcion ASC")
    List<Comida> metodoNativo(@Param("precioInf") double precioInf, @Param("precioSup") double precioSup);
}