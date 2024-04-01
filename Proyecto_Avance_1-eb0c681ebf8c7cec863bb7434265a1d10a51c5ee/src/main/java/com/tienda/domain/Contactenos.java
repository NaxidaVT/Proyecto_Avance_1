package com.tienda.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "contactenos")
public class Contactenos implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contactenos")
    private Long idContactenos;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "ruta_imagen")
    private String rutaImagen;

    @Column(name = "activo")
    private boolean activo;

    @Column(name = "provincia")
    private String provincia;

    @Column(name = "correo")
    private String correo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "asunto")
    private String asunto;

    @Column(name = "mensaje")
    private String mensaje;

    @OneToMany
    @JoinColumn(name = "id_contactenos", updatable = false)
    private List<Producto> productos;

    public Contactenos() {
    }

    public Contactenos(String descripcion, boolean activo) {
        this.descripcion = descripcion;
        this.activo = activo;
    }

    // Getters and setters
}
