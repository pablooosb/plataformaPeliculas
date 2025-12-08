package edu.pabloSalgado.practica.plataformaPeliculas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.pabloSalgado.practica.plataformaPeliculas.model.Pelicula_plataforma;

@Repository
public interface Pelicula_plataformaRepository extends JpaRepository<Pelicula_plataforma, Long>{
    // peliculas cuyo precio de compra sea inferior a 10 USD
    @Query("SELECT pP.pelicula.pelicula_id FROM Pelicula_plataforma pP WHERE pP.compra.amount < ?1")
    List<Long> findPeliculasIdPrecioCompraMenorQue(Double precioCompra);
}
