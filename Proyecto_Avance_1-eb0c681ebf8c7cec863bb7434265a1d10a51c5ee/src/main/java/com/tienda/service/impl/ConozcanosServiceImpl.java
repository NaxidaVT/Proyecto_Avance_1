package com.tienda.service.impl;

import com.tienda.dao.ConozcanosDao;
import com.tienda.domain.Conozcanos;
import com.tienda.service.ConozcanosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ConozcanosServiceImpl implements ConozcanosService {

    @Autowired
    private ConozcanosDao conozcanosDao;

    @Override
    @Transactional(readOnly = true)
    public List<Conozcanos> getConozcanos(boolean activos) {
        var lista = conozcanosDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Conozcanos getConozcanos(Conozcanos conozcanos) {
        return conozcanosDao.findById(conozcanos.getIdConozcanos()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Conozcanos conozcanos) {
        conozcanosDao.save(conozcanos);
    }

    @Override
    @Transactional
    public void delete(Conozcanos conozcanos) {
        conozcanosDao.delete(conozcanos);
    }

}
