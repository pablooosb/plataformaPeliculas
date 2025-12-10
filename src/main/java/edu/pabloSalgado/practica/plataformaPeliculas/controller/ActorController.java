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

import edu.pabloSalgado.practica.plataformaPeliculas.mapper.ActorMapper;
import edu.pabloSalgado.practica.plataformaPeliculas.model.Actor;
import edu.pabloSalgado.practica.plataformaPeliculas.model.dto.ActorDTO;
import edu.pabloSalgado.practica.plataformaPeliculas.service.interfaces.IActorService;

@RestController
@RequestMapping("/actores")
public class ActorController {
    @Autowired
    private IActorService actorService;
    @Autowired
    private ActorMapper actorMapper;

    @PostMapping("/add")
    public ActorDTO addActor(@RequestBody ActorDTO actorDTO){
        Actor actor = actorService.addActor(actorDTO);
        return actorMapper.toDto(actor);
    }

    @GetMapping
    public List<Actor> listarActores(){
        return actorService.showAllActors();
    }

    @GetMapping("/{id}")
    public ActorDTO actorPorId(@PathVariable("id") Long id){
        return actorMapper.toDto(actorService.showActorById(id));
    }

    @PostMapping("/update")
    public ActorDTO updateActor(@RequestBody ActorDTO actorDTO){
        Actor actor = actorMapper.toEntity(actorDTO);
        Actor updated = actorService.updateActor(actor);
        return actorMapper.toDto(updated);    
    }

    @DeleteMapping("/delete/{id}")
    public void deleteActor(@PathVariable("id") Long id){
        actorService.deleteActorById(id);
    }

    // Endpoint para obtener actores activos
    @GetMapping("/activos")
    public List<Actor> findActoresActivos(){
        return actorService.findActoresActivos();
    }
}
