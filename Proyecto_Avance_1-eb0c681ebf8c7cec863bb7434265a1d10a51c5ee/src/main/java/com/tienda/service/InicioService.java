package com.tienda.service;

import com.tienda.domain.Inicio;
import java.util.List;

public interface InicioService {

    public List<Inicio> getInicio(boolean activo);

    public Inicio getInicio(Inicio inicio);
    

    public void save(Inicio inicio);
    
    public void delete(Inicio inicio);
}
