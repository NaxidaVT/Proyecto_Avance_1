package com.tienda.dao;

import com.tienda.domain.Contactenos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactenosDao extends JpaRepository <Contactenos, Long> {
    
}
