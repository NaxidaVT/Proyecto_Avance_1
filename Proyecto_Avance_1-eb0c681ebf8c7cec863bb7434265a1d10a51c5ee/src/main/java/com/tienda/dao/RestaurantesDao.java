package com.tienda.dao;

import com.tienda.domain.Restaurantes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantesDao extends JpaRepository <Restaurantes, Long> {
    
}
