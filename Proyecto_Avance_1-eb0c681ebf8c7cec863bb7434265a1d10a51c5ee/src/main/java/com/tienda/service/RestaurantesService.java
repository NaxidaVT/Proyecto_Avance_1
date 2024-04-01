package com.tienda.service;

import com.tienda.domain.Restaurantes;
import java.util.List;

public interface RestaurantesService {

    public List<Restaurantes> getRestaurantes(boolean activo);

    // Se obtiene un Restaurantes, a partir del id de un restaurante
    public Restaurantes getRestaurantes(Restaurantes restaurantes);
    
    // Se inserta un nuevo restaurante si el id del restaurante esta vacío
    // Se actualiza un restaurante si el id del restaurante NO esta vacío
    public void save(Restaurantes restaurantes);
    
    // Se elimina el restaurante que tiene el id pasado por parámetro
    public void delete(Restaurantes restaurantes);
}
