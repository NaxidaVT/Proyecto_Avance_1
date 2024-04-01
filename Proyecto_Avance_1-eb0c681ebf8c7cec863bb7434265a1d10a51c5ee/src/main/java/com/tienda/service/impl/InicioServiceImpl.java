package com.tienda.service.impl;

import com.tienda.dao.InicioDao;
import com.tienda.domain.Inicio;
import com.tienda.service.InicioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class InicioServiceImpl implements InicioService {

     @Autowired
    private InicioDao InicioDao;

    @Override
    @Transactional(readOnly = true)
    public List<Inicio> getInicio(boolean activos) {
        var lista = InicioDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Inicio getInicio(Inicio inicio) {
        return InicioDao.findById(inicio.getIdInicio()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Inicio inicio) {
        InicioDao.save(inicio);
    }

    @Override
    @Transactional
    public void delete(Inicio inicio) {
        InicioDao.delete(inicio);
    }
    
}
