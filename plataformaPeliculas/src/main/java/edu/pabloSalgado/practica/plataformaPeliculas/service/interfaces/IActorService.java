package edu.pabloSalgado.practica.plataformaPeliculas.service.interfaces;

import java.util.List;

import edu.pabloSalgado.practica.plataformaPeliculas.model.Actor;

public interface IActorService {
    List<Actor> ontenerTodosLosActores();
    Actor obtenerActorPorId(Long id);
    Actor actualizarOGuardar(Actor actor);
    void eliminarActor(Long id);
}
