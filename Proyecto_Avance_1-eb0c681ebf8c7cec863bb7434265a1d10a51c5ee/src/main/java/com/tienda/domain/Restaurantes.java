package com.tienda.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "restaurantes")
public class Restaurantes implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_restaurante")
    private Long idRestaurante;
    private String nombre;
    private String descripcion;
    private String rutaImagen;
    private boolean activo;

    @OneToMany
    @JoinColumn(name = "id_restaurante", updatable = false)
    List<Producto> productos;

    public Restaurantes() {
    }

    public Restaurantes(String nombre, String descripcion, boolean activo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.activo = activo;
    }

}
