/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package VillaGastronotiica.demo.dao;

import VillaGastronotiica.demo.domain.Usuario;

/**
 *
 * @author EsteP
 */
public interface UsuarioDao {

    public Usuario findByCorreo(String username);
    
}
