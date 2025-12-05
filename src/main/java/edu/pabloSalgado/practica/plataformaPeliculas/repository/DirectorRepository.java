package edu.pabloSalgado.practica.plataformaPeliculas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.pabloSalgado.practica.plataformaPeliculas.model.Director;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Long>{
    
}
