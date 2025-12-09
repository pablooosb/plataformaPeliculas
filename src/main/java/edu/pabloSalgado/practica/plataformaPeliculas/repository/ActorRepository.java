package edu.pabloSalgado.practica.plataformaPeliculas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.pabloSalgado.practica.plataformaPeliculas.model.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long>{
    // buscar actores activos
    @Query("SELECT a FROM Actor a WHERE a.activo = true")
    List<Actor> findActoresActivos();
}
