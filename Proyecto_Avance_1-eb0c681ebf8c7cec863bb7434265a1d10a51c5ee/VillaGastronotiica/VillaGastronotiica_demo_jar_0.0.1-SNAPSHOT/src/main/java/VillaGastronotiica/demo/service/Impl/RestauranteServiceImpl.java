/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VillaGastronotiica.demo.service.Impl;

import VillaGastronotiica.demo.dao.RestauranteDao;
import VillaGastronotiica.demo.domain.Restaurante;
import VillaGastronotiica.demo.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RestauranteServiceImpl implements RestauranteService {
    @Autowired
    private RestauranteDao restauranteDao;

    @Override
    public List<Restaurante> getAllRestaurantes() {
        return restauranteDao.findAll();
    }

    @Override
    public void saveRestaurante(Restaurante restaurante) {
        restauranteDao.save(restaurante);
    }

    @Override
    public void deleteRestaurante(Long id) {
        restauranteDao.deleteById(id);
    }

    @Override
    public Restaurante getRestauranteById(Long id) {
        return restauranteDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Restaurante getRestaurante(Long id) {
        return restauranteDao.findById(id).orElse(null);
    }

    @Override
    public List<Restaurante> getRestaurantes(boolean activo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object getAllRestaurante() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}