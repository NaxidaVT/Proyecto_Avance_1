/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package VillaGastronotiica.demo.service.Impl;

import VillaGastronotiica.demo.dao.FavoritoDao;
import VillaGastronotiica.demo.domain.Favorito;
import VillaGastronotiica.demo.service.FavoritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class FavoritoServiceImpl implements FavoritoService {
    
    @Autowired
    private FavoritoDao favoritoDao;

    @Transactional(readOnly = true)
    public List<Favorito> obtenerFavoritosPorUsuario(Long usuarioId) {
        return favoritoDao.findByUsuarioId(usuarioId);
    }

    @Transactional
    public void guardarFavorito(Favorito favorito) {
        favoritoDao.save(favorito);
    }

    @Transactional
    public void eliminarFavorito(Long favoritoId) {
        favoritoDao.deleteById(favoritoId);
    }

    @Transactional
    public void marcarFavorito(Long usuarioId, Long comidaId, Long restauranteId, String comentario) {
        Favorito favorito = new Favorito();
        favorito.setUsuarioId(usuarioId);
        favorito.setComidaId(comidaId);
        favorito.setRestauranteId(restauranteId);
        favorito.setComentario(comentario);
        favoritoDao.save(favorito);
    }
}