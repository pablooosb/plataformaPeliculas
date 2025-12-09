package edu.pabloSalgado.practica.plataformaPeliculas.service.interfaces;

import java.util.List;

import edu.pabloSalgado.practica.plataformaPeliculas.model.Pelicula;
import edu.pabloSalgado.practica.plataformaPeliculas.model.Pelicula_plataforma;
import edu.pabloSalgado.practica.plataformaPeliculas.model.dto.Pelicula_plataformaDTO;

public interface IPelicula_plataformaService {
    // Añadir pelicula_plataforma
    Pelicula_plataforma addPeliculaPlataforma(Pelicula_plataformaDTO dto);
    // Obtener todas las peliculas_plataforma
    List<Pelicula_plataforma> showAllPeliculasPlataforma();
    // obtener pelicula_plataforma por id
    Pelicula_plataforma showPeliculaPlataformaById(Long id);
    // Actualizar pelicula_plataforma por id
    Pelicula_plataforma updatePeliculaPlataforma(Pelicula_plataforma pelicula_plataforma);
    // Eliminar pelicula_plataforma por id
    void deletePeliculaPlataformaById(Long id);
    // Obtener las peliculas con precio de compra menor a 10
    List<Pelicula> findPeliculasPrecioCompraMenorQue(Double precio);
    // Obtener el numero de peliculas por plataforma de streaming
    int countPeliculasByPlataformaStreamingId(int plataforma_streaming_id);
}
