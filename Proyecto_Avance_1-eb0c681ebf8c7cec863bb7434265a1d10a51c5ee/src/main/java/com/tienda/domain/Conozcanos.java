package com.tienda.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "conozcanos")
public class Conozcanos implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conozcanos")
    private Long idConozcanos;
    private String descripcion;
    private String rutaImagen;
    private boolean activo;

    @OneToMany
    @JoinColumn(name = "id_conozcanos", updatable = false)
    List<Producto> productos;

    public Conozcanos() {
    }

    public Conozcanos(String descripcion, boolean activo) {
        this.descripcion = descripcion;
        this.activo = activo;
    }

}
