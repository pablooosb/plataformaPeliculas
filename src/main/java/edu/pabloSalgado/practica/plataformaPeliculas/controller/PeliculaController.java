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
import edu.pabloSalgado.practica.plataformaPeliculas.model.dto.PeliculaDTO;
import edu.pabloSalgado.practica.plataformaPeliculas.model.mapper.PeliculaMapper;
import edu.pabloSalgado.practica.plataformaPeliculas.service.interfaces.IPeliculaService;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {
    @Autowired
    private IPeliculaService peliculaService;
    @Autowired
    private PeliculaMapper peliculaMapper;

    @PostMapping("/add")
    public PeliculaDTO addPelicula(@RequestBody PeliculaDTO peliculaDTO){
        Pelicula pelicula = peliculaService.addPelicula(peliculaDTO);
        return peliculaMapper.toDto(pelicula);
    }

    @GetMapping
    public List<Pelicula> listarPeliculas(){
        return peliculaService.showAllPeliculas();
    }

    @GetMapping("/{id}")
    public PeliculaDTO peliculaPorId(@PathVariable("id") Long id){
        return peliculaMapper.toDto(peliculaService.showPeliculaById(id));
    }

    @PostMapping("/update")
    public PeliculaDTO updatePelicula(@RequestBody PeliculaDTO peliculaDTO){
        Pelicula pelicula = peliculaMapper.toEntity(peliculaDTO);
        Pelicula updated = peliculaService.updatePelicula(pelicula);
        return peliculaMapper.toDto(updated);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePelicula(@PathVariable("id") Long id){
        peliculaService.deletePeliculaById(id);
    }

    // Endpoint para obtener peliculas aptas para un niño de 12 años
    @GetMapping("/aptas12")
    public List<Pelicula> getPeliculasAptas12(){
        return peliculaService.getPeliculasAptas12();
    }
}
