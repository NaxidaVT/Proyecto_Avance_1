package com.tienda.dao;

import com.tienda.domain.Inicio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InicioDao extends JpaRepository <Inicio, Long> {
    
}
