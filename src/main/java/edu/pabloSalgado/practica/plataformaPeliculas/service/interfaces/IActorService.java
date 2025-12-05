package edu.pabloSalgado.practica.plataformaPeliculas.service.interfaces;

import java.util.List;

import edu.pabloSalgado.practica.plataformaPeliculas.model.Actor;
import edu.pabloSalgado.practica.plataformaPeliculas.model.dto.ActorDTO;

public interface IActorService {
    // añadir actor
    Actor addActor(ActorDTO dto);
    // obtener todos los actores
    List<Actor> showAllActors();
    // obtener actor por id
    Actor showActorById(Long id);
    // actualizar actores por id
    Actor updateActorById(Long id, ActorDTO dto);
    // eliminar actor por id
    void deleteActorById(Long id);
}
