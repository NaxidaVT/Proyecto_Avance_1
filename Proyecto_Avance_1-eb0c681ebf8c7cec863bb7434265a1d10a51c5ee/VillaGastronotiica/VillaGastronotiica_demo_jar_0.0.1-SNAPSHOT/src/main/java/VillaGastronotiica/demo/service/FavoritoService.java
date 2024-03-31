/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package VillaGastronotiica.demo.service;

/**
 *
 * @author 11alp
 */
public interface FavoritoService {
    void marcarFavorito(Long usuarioId, Long comidaId, Long restauranteId, String comentario);
}
