package edu.pabloSalgado.practica.plataformaPeliculas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pabloSalgado.practica.plataformaPeliculas.model.Actor;
import edu.pabloSalgado.practica.plataformaPeliculas.service.interfaces.IActorService;

@RestController
@RequestMapping("/actores")
public class ActorController {
    @Autowired
    private IActorService actorService;

    // Endpoint para obtener actores activos
    @GetMapping("/activos")
    public List<Actor> findActoresActivos(){
        return actorService.findActoresActivos();
    }
}
