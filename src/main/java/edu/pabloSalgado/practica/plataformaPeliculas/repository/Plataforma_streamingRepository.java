package edu.pabloSalgado.practica.plataformaPeliculas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.pabloSalgado.practica.plataformaPeliculas.model.Plataforma_streaming;

@Repository
public interface Plataforma_streamingRepository extends JpaRepository<Plataforma_streaming, Long>{
    // Buscamos por nombre
    public List<Plataforma_streaming> findByNombre(String nombre);
    // Buscamos por pais
    public List<Plataforma_streaming> findByPais(String pais);
}
