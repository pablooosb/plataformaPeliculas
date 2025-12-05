package edu.pabloSalgado.practica.plataformaPeliculas.service.interfaces;

import java.util.List;

import edu.pabloSalgado.practica.plataformaPeliculas.model.Pelicula_plataforma;
import edu.pabloSalgado.practica.plataformaPeliculas.model.dto.Pelicula_plataformaDTO;

public interface IPelicula_plataformaService {
    // añadir pelicula_plataforma
    Pelicula_plataforma addPeliculaPlataforma(Pelicula_plataformaDTO dto);
    // Obtener todas las peliculas_plataforma
    List<Pelicula_plataforma> showAllPeliculasPlataforma();
    // obtener pelicula_plataforma por id
    Pelicula_plataforma showPeliculaPlataformaById(Long id);
    // Actualizar pelicula_plataforma por id
    Pelicula_plataforma updatePeliculaPlataformaById(Long id, Pelicula_plataformaDTO pelicula_plataformaDTO);
    // Eliminar pelicula_plataforma por id
    void deletePeliculaPlataformaById(Long id);
}
