package com.tienda.service.impl;

import com.tienda.dao.RestaurantesDao;
import com.tienda.domain.Restaurantes;
import com.tienda.service.RestaurantesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RestaurantesServiceImpl implements RestaurantesService {

    @Autowired
    private RestaurantesDao restaurantesDao;

    @Override
    @Transactional(readOnly = true)
    public List<Restaurantes> getRestaurantes(boolean activos) {
        var lista = restaurantesDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Restaurantes getRestaurantes(Restaurantes restaurantes) {
        return restaurantesDao.findById(restaurantes.getIdRestaurante()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Restaurantes restaurantes) {
        restaurantesDao.save(restaurantes);
    }

    @Override
    @Transactional
    public void delete(Restaurantes restaurantes) {
        restaurantesDao.delete(restaurantes);
    }
    
}
