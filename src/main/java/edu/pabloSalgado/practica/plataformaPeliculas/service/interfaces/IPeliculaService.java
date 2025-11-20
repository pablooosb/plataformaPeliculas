package edu.pabloSalgado.practica.plataformaPeliculas.service.interfaces;

import java.util.List;

import edu.pabloSalgado.practica.plataformaPeliculas.model.Pelicula;

public interface IPeliculaService {
    List<Pelicula> obtenerTodasLasPeliculas();
    Pelicula obtenerPeliculaPorId(Long id);
    Pelicula actualizarOGuardar(Pelicula pelicula);
    void eliminarPelicula(Long id);
}
