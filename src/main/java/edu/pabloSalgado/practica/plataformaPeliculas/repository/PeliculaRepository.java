package edu.pabloSalgado.practica.plataformaPeliculas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.pabloSalgado.practica.plataformaPeliculas.model.Pelicula;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Long>{
    // buscar peliculas que pueda ver un niño de 12 años
    @Query("SELECT p FROM Pelicula p WHERE p.edadMinima IN(PEGI_3, PEGI_7, PEGI_12)")
    List<Pelicula> getPeliculasAptas12();
}