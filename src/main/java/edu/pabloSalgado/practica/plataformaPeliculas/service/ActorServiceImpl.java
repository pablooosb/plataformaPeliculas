package edu.pabloSalgado.practica.plataformaPeliculas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import edu.pabloSalgado.practica.plataformaPeliculas.model.Actor;
import edu.pabloSalgado.practica.plataformaPeliculas.model.dto.ActorDTO;
import edu.pabloSalgado.practica.plataformaPeliculas.model.vo.Dni;
import edu.pabloSalgado.practica.plataformaPeliculas.model.vo.Fecha_nacimiento;
import edu.pabloSalgado.practica.plataformaPeliculas.repository.ActorRepository;
import edu.pabloSalgado.practica.plataformaPeliculas.service.interfaces.IActorService;

@Service
public class ActorServiceImpl implements IActorService{
    private ActorRepository actorRepo;

    public ActorServiceImpl(ActorRepository actorRepo){
        this.actorRepo  = actorRepo;
    }

    @Override
    public Actor addActor(ActorDTO dto){
        Actor actor = new Actor();

        actor.setNombre(dto.nombre());
        actor.setApellido(dto.apellido());

        Dni dni = new Dni(dto.dniNumero(), dto.dniLetra());
        actor.setDni(dni);

        actor.setNacionalidad(dto.nacionalidad());
        actor.setActivo(dto.activo());

        Fecha_nacimiento fecha_nacimiento = new Fecha_nacimiento(dto.nacimientoDia(), dto.nacimientoMes(), dto.nacimientoAnho());
        actor.setFecha_nacimiento(fecha_nacimiento);

        return actorRepo.save(actor);
    }

    @Override
    public List<Actor> showAllActors(){
        return actorRepo.findAll();
    }

    @Override
    public Actor showActorById(Long id){
        Optional<Actor> op = actorRepo.findById(id);
        if (op.isPresent()){
            return op.get();
        }
        return null;
    }

    @Override
    public Actor updateActorById(Long id, ActorDTO dto){
        Actor actor = actorRepo.findById(id).orElseThrow(() -> new RuntimeException("Actor no encontrado con id " + id));

        actor.setNombre(dto.nombre());
        actor.setApellido(dto.apellido());

        Dni dni = new Dni(dto.dniNumero(), dto.dniLetra());
        actor.setDni(dni);

        actor.setNacionalidad(dto.nacionalidad());
        actor.setActivo(dto.activo());

        Fecha_nacimiento fecha_nacimiento = new Fecha_nacimiento(dto.nacimientoDia(), dto.nacimientoMes(), dto.nacimientoAnho());
        actor.setFecha_nacimiento(fecha_nacimiento);

        return actorRepo.save(actor);
    }

    @Override
    public void deleteActorById(Long id){
        if (!actorRepo.existsById(id)){
            throw new IllegalArgumentException("Actor con id " + id + " no encontrado");
        } actorRepo.deleteById(id);
    }
}
