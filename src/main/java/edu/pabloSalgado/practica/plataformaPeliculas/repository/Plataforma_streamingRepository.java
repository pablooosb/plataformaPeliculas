package edu.pabloSalgado.practica.plataformaPeliculas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.pabloSalgado.practica.plataformaPeliculas.model.Plataforma_streaming;

@Repository
public interface Plataforma_streamingRepository extends JpaRepository<Plataforma_streaming, Long>{
    // mostrar los paises contando las plataformas de streaming que tiene cada uno
    @Query("SELECT pS.pais, COUNT(*)" + "FROM Plataforma_streaming pS " + "GROUP BY pS.pais")
    List<Object[]> countPlataformasStreamingByPais();
}
