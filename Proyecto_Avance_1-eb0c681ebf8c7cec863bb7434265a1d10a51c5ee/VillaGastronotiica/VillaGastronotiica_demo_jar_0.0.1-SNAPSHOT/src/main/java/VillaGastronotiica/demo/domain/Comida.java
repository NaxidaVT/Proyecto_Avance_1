/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VillaGastronotiica.demo.domain;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Comidas") 
public class Comida implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID") 
    private Long id;
    
    @Column(name="Nombre") 
    private String nombre;
    
    @Column(name="Descripcion") 
    private String descripcion;
    
    @Column(name="Precio") 
    private double precio;
    
    @ManyToOne
    @JoinColumn(name="RestauranteID") 
    private Restaurante restaurante;

    public Comida() {
    }

    public Comida(String nombre, String descripcion, double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public boolean isActiva() {
        return this.descripcion != null && !this.descripcion.isEmpty() && this.precio > 0;
    }
}