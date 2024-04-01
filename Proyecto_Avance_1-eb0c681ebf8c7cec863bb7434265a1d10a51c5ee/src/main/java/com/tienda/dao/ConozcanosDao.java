package com.tienda.dao;

import com.tienda.domain.Conozcanos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConozcanosDao extends JpaRepository <Conozcanos, Long> {
    
}
