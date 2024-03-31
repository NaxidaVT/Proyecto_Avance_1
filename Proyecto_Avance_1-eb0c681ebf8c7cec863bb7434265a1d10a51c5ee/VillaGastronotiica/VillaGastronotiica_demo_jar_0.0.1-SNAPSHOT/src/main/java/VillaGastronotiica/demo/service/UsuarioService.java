/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package VillaGastronotiica.demo.service;

import VillaGastronotiica.demo.domain.Usuario;
import java.util.List;

public interface UsuarioService {

    List<Usuario> getAllUsuarios();

    Usuario getUsuarioById(Long id);

    void saveUsuario(Usuario usuario);

    void updateUsuario(Usuario usuario);

    void deleteUsuario(Long id);

    boolean existsByEmail(String correo);

    Usuario getUsuarioByCorreo(String correo);
}