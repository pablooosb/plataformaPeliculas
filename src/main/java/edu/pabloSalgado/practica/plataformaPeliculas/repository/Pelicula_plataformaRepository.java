package edu.pabloSalgado.practica.plataformaPeliculas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.pabloSalgado.practica.plataformaPeliculas.model.Pelicula_plataforma;

@Repository
public interface Pelicula_plataformaRepository extends JpaRepository<Pelicula_plataforma, Long>{

}
