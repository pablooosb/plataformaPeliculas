package edu.pabloSalgado.practica.plataformaPeliculas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pabloSalgado.practica.plataformaPeliculas.model.Pelicula;
import edu.pabloSalgado.practica.plataformaPeliculas.model.Pelicula_plataforma;
import edu.pabloSalgado.practica.plataformaPeliculas.model.dto.Pelicula_plataformaDTO;
import edu.pabloSalgado.practica.plataformaPeliculas.model.mapper.Pelicula_plataformaMapper;
import edu.pabloSalgado.practica.plataformaPeliculas.repository.Pelicula_plataformaRepository;
import edu.pabloSalgado.practica.plataformaPeliculas.service.interfaces.IPelicula_plataformaService;

@RestController
@RequestMapping("/peliculasPlataformas")
public class PeliculaPlataformaController {
    @Autowired
    private Pelicula_plataformaRepository pelicula_plataformaRepository;
    @Autowired
    private IPelicula_plataformaService pelicula_plataformaService;
    @Autowired
    private Pelicula_plataformaMapper pelicula_plataformaMapper;

    @PostMapping("/add")
    public Pelicula_plataformaDTO addPeliculaPlataforma(@RequestBody Pelicula_plataformaDTO pelicula_plataformaDTO){
        Pelicula_plataforma pelicula_plataforma = pelicula_plataformaService.addPeliculaPlataforma(pelicula_plataformaDTO);
        return pelicula_plataformaMapper.toDto(pelicula_plataforma);
    }

    @GetMapping
    public List<Pelicula_plataforma> listarPeliculasPlataformas(){
        return pelicula_plataformaService.showAllPeliculasPlataforma();
    }

    @PostMapping("/update")
    public Pelicula_plataformaDTO updatePeliculaPlataforma(@RequestBody Pelicula_plataformaDTO pelicula_plataformaDTO){
        Pelicula_plataforma pelicula_plataforma = pelicula_plataformaMapper.toEntity(pelicula_plataformaDTO);
        Pelicula_plataforma updated = pelicula_plataformaService.updatePeliculaPlataforma(pelicula_plataforma);
        return pelicula_plataformaMapper.toDto(updated);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePeliculaPlataforma(@PathVariable("id") Long id){
        try {
            pelicula_plataformaService.deletePeliculaPlataformaById(id);
        } catch (Exception e){
            System.err.println("Error al eliminar la pelicula plataforma con id " + id + ": " + e.getMessage());
            throw e;
        }
    }

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