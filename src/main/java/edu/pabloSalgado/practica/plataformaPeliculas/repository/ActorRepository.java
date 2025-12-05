package edu.pabloSalgado.practica.plataformaPeliculas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.pabloSalgado.practica.plataformaPeliculas.model.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long>{
    
}
