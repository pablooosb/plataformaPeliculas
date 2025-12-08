package edu.pabloSalgado.practica.plataformaPeliculas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pabloSalgado.practica.plataformaPeliculas.repository.Pelicula_plataformaRepository;

@RestController
@RequestMapping("/peliculas")
public class PeliculaPlataformaController {

    @Autowired
    private Pelicula_plataformaRepository pelicula_plataformaRepository;

    // Endpoint para obtener los pelicula_id con precio de compra menor a 10
    @GetMapping("/baratas")
    public List<Long> getPeliculasBaratas() {
        return pelicula_plataformaRepository.findPeliculasIdPrecioCompraMenorQue(10.0);
    }
}
