package edu.pabloSalgado.practica.plataformaPeliculas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pabloSalgado.practica.plataformaPeliculas.model.Pelicula;
import edu.pabloSalgado.practica.plataformaPeliculas.repository.Pelicula_plataformaRepository;
import edu.pabloSalgado.practica.plataformaPeliculas.service.interfaces.IPelicula_plataformaService;

@RestController
@RequestMapping("/peliculaPlataforma")
public class PeliculaPlataformaController {
    @Autowired
    private Pelicula_plataformaRepository pelicula_plataformaRepository;
    @Autowired
    private IPelicula_plataformaService pelicula_plataformaService;

    // Endpoint para obtener el objeto pelicula con precio de compra menor a 10
    @GetMapping("/peliculasBaratas")
    public List<Pelicula> getPeliculasBaratas() {
        return pelicula_plataformaRepository.findPeliculasIdPrecioCompraMenorQue(10.0);
    }

    // Endpoint para obtener cuantas peliculas tiene cada plataforma de streaming
    @GetMapping("/{plataforma_streaming_id}/plataformaStreaming/count")
    public int countPeliculasByPlataformaStreamingId(@PathVariable int plataforma_streaming_id){
        return pelicula_plataformaService.countPeliculasByPlataformaStreamingId(plataforma_streaming_id);
    }
}