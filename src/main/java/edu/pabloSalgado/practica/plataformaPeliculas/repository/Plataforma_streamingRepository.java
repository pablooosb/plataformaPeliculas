package edu.pabloSalgado.practica.plataformaPeliculas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.pabloSalgado.practica.plataformaPeliculas.model.Plataforma_streaming;
import edu.pabloSalgado.practica.plataformaPeliculas.model.enums.Pais;

@Repository
public interface Plataforma_streamingRepository extends JpaRepository<Plataforma_streaming, Long>{
    // mostrar las plataformas de streaming que sean de USA
    @Query("SELECT p FROM Plataforma_streaming p WHERE p.pais = :pais")
    List<Plataforma_streaming> findPlataformasStreamingByPais(Pais pais);
}
