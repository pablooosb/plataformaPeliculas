package edu.pabloSalgado.practica.plataformaPeliculas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pabloSalgado.practica.plataformaPeliculas.model.Actor;
import edu.pabloSalgado.practica.plataformaPeliculas.repository.ActorRepository;
import edu.pabloSalgado.practica.plataformaPeliculas.service.interfaces.IActorService;

@Service
public class ActorServiceImpl implements IActorService{
    @Autowired
    private ActorRepository actorRepo;

    @Override
    public List<Actor> ontenerTodosLosActores(){
        return actorRepo.findAll();
    }

    @Override
    public Actor obtenerActorPorId(Long id){
        Optional<Actor> op = actorRepo.findById(id);
        if (op.isPresent()) {
            return op.get();
        }
        return null;
    }
    
    @Override
    public Actor actualizarOGuardar(Actor actor){
        if (actor.getActor_id() == null) {
            System.out.println("Guardamos " + actor + " en la base de datos");
            return actorRepo.save(actor);
        } else{
            if (actorRepo.existsById(actor.getActor_id())) {
                System.out.println("Actualizamos el actor " + actor + " en la base de datos");
                return actorRepo.save(actor);
            } else{
                System.out.println("No exite ningún actor");
                return null;
            }
        }
    }

    @Override
    public void eliminarActor(Long id){
        if (actorRepo.existsById(id)) {
            actorRepo.deleteById(id);
        } else{
            throw new RuntimeException("Actor no encontrado con id " + id);
        }
    }
}
