package com.tienda.service.impl;

import com.tienda.dao.ContactenosDao;
import com.tienda.domain.Contactenos;
import com.tienda.service.ContactenosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContactenosServiceImpl implements ContactenosService {

    @Autowired
    private ContactenosDao contactenosDao;

    @Override
    @Transactional(readOnly = true)
    public List<Contactenos> getContactenos(boolean activos) {
        var lista = contactenosDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Contactenos getContactenos(Contactenos contactenos) {
        return contactenosDao.findById(contactenos.getIdContactenos()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Contactenos contactenos) {
        contactenosDao.save(contactenos);
    }

    @Override
    @Transactional
    public void delete(Contactenos contactenos) {
        contactenosDao.delete(contactenos);
    }

}
