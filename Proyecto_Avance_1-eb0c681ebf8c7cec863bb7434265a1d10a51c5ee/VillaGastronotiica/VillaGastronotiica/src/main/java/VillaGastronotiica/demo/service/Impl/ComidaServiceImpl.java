/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VillaGastronotiica.demo.service.Impl;



import VillaGastronotiica.demo.dao.ComidaDao;
import VillaGastronotiica.demo.domain.Comida;
import VillaGastronotiica.demo.service.ComidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ComidaServiceImpl implements ComidaService {
    
    @Autowired
    private ComidaDao comidaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Comida> getComidas(boolean activas) {
        List<Comida> comidas = comidaDao.findAll();
        if (activas) {
            comidas.removeIf(comida -> !comida.isActiva());
        }
        return comidas;
    }

    @Override
    @Transactional(readOnly = true)
    public Comida getComidaById(Long id) {
        return comidaDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void saveComida(Comida comida) {
        comidaDao.save(comida);
    }

    @Override
    @Transactional
    public void deleteComida(Long id) {
        comidaDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Comida getComida(Long id) {
        return comidaDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Comida> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup) {
        return comidaDao.findByPrecioBetweenOrderByDescripcion(precioInf, precioSup);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Comida> metodoJPQL(double precioInf, double precioSup) {
        return comidaDao.metodoJPQL(precioInf, precioSup);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Comida> metodoNativo(double precioInf, double precioSup) {
        return comidaDao.metodoNativo(precioInf, precioSup);
    }

    @Override
    public List<Comida> getAllComida() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}