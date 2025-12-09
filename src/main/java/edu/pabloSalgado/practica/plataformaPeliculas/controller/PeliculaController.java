package edu.pabloSalgado.practica.plataformaPeliculas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pabloSalgado.practica.plataformaPeliculas.model.Pelicula;
import edu.pabloSalgado.practica.plataformaPeliculas.service.interfaces.IPeliculaService;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {
    @Autowired
    private IPeliculaService peliculaService;

    // buscar peliculas aptas para un niño de 12 años
    @GetMapping("/aptas12")
    public List<Pelicula> getPeliculasAptas12(){
        return peliculaService.getPeliculasAptas12();
    }
}
