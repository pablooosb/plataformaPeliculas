package edu.pabloSalgado.practica.plataformaPeliculas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.pabloSalgado.practica.plataformaPeliculas.model.Pelicula;
import edu.pabloSalgado.practica.plataformaPeliculas.model.Pelicula_plataforma;

@Repository
public interface Pelicula_plataformaRepository extends JpaRepository<Pelicula_plataforma, Long>{
    // mostrar peliculas cuyo precio de compra sea inferior a 10
    @Query("SELECT pP.pelicula FROM Pelicula_plataforma pP WHERE pP.compra.amount < ?1")
    List<Pelicula> findPeliculasIdPrecioCompraMenorQue(Double precioCompra);
    
    // mostrar las plataformas con cuantas peliculas tienen
    @Query("SELECT COUNT(pP) FROM Pelicula_plataforma pP WHERE pP.plataforma_streaming.id = :plataformaStreamingId")
    int countPeliculasByPlataformaStreamingId(@Param("plataformaStreamingId") int plataformaStreamingId);
}
