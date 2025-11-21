package edu.pabloSalgado.practica.plataformaPeliculas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.pabloSalgado.practica.plataformaPeliculas.model.Actor;
import edu.pabloSalgado.practica.plataformaPeliculas.model.vo.Dni;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long>{
    // Buscar por id
    public Optional<Actor> findById(Long id);
    // Buscar por nombre
    public List<Actor> findByNombre(String nombre);
    // Buscar por DNI
    public Optional<Actor> findByDni(Dni dni);
    // Buscar los que están activos
    public List<Actor> findByActivoTrue();
}
