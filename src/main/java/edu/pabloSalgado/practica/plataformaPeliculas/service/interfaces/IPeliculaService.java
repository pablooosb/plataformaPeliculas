package edu.pabloSalgado.practica.plataformaPeliculas.service.interfaces;

import java.util.List;

import edu.pabloSalgado.practica.plataformaPeliculas.model.Pelicula;
import edu.pabloSalgado.practica.plataformaPeliculas.model.dto.PeliculaDTO;

public interface IPeliculaService {
    // añadir pelicula
    Pelicula addPelicula(PeliculaDTO dto);
    // obtener todas las peliculas
    List<Pelicula> showAllPeliculas();
    // obtener pelicula por id
    Pelicula showPeliculaById(Long id);
    // actualizar pelicula por id
    Pelicula updatePelicula(Pelicula pelicula);
    // eliminar pelicula por id
    void deletePeliculaById(Long id);
    // obtener peliculas aptas para un niño de 12 años
    List<Pelicula> getPeliculasAptas12();
}
