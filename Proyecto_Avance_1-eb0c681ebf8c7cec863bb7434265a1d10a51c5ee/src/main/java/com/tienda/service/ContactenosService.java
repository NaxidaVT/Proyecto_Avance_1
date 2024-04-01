package com.tienda.service;

import com.tienda.domain.Contactenos;
import java.util.List;

public interface ContactenosService {

    public List<Contactenos> getContactenos(boolean activo);

    // Se obtiene un Categoria, a partir del id de un categoria
    public Contactenos getContactenos(Contactenos contactenos);
    
    // Se inserta un nuevo categoria si el id del categoria esta vacío
    // Se actualiza un categoria si el id del categoria NO esta vacío
    public void save(Contactenos contactenos);
    
    // Se elimina el categoria que tiene el id pasado por parámetro
    public void delete(Contactenos contactenos);
}
