package edu.pabloSalgado.practica.plataformaPeliculas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.pabloSalgado.practica.plataformaPeliculas.model.Actor;
import edu.pabloSalgado.practica.plataformaPeliculas.model.Director;
import edu.pabloSalgado.practica.plataformaPeliculas.model.vo.Dni;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Long>{
    // Buscar por nombre
    List<Actor> findByNombre(String nombre);
    // Buscar por DNI
    Optional<Actor> findByDni(Dni dni);
    // Buscar los que están activos
    List<Actor> findByActivoTrue();
}
