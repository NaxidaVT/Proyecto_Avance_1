package com.tienda.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "inicio")
public class Inicio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inicio")
    private Long idInicio;
    private String descripcion;
    private String rutaImagen;
    private boolean activo;

    @OneToMany
    @JoinColumn(name = "id_inicio", updatable = false)
    List<Producto> productos;

    public Inicio() {
    }

    public Inicio(String descripcion, boolean activo) {
        this.descripcion = descripcion;
        this.activo = activo;
    }

}

      