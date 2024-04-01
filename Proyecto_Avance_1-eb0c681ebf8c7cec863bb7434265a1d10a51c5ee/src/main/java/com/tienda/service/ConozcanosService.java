package com.tienda.service;

import com.tienda.domain.Conozcanos;
import java.util.List;

public interface ConozcanosService {

    public List<Conozcanos> getConozcanos(boolean activo);

    // Se obtiene un Categoria, a partir del id de un categoria
    public Conozcanos getConozcanos(Conozcanos conozcanos);

    // Se inserta un nuevo categoria si el id del categoria esta vacío
    // Se actualiza un categoria si el id del categoria NO esta vacío
    public void save(Conozcanos conozcanos);

    // Se elimina el categoria que tiene el id pasado por parámetro
    public void delete(Conozcanos conozcanos);
}
