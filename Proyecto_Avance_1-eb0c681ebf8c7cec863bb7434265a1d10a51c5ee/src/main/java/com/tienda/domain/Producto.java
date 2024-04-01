package com.tienda.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="producto")

public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_producto")
    private Long idProducto;
    
    //private Long idRestaurante(false);
    private String nombre;
    private String descripcion;
    private double precio;
    private String restauranteId;
    private int existencias;
    private String rutaImagen;
    private boolean activo;

    @ManyToOne
    @JoinColumn(name="id_restaurantes")
    Restaurantes restaurantes;


    public Producto() {
    }

    public Producto(String descripcion, boolean activo) {
        this.descripcion = descripcion;
        this.activo = activo;
    }
    
}