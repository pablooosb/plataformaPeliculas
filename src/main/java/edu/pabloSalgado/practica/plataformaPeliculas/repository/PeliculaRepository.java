package edu.pabloSalgado.practica.plataformaPeliculas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.pabloSalgado.practica.plataformaPeliculas.model.Pelicula;
import edu.pabloSalgado.practica.plataformaPeliculas.model.enums.Edad_recomendada;
import edu.pabloSalgado.practica.plataformaPeliculas.model.enums.Genero;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Long>{
    // Buscar por titulo
    public List<Pelicula> findByTitulo(String titulo);
    // Buscar por genero
    public List<Pelicula> findByGenero(Genero genero);
    // Buscar por edad recomendada
    public List<Pelicula> findByEdad_recomendada(Edad_recomendada edad_recomendada);
}
