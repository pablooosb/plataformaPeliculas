package edu.pabloSalgado.practica.plataformaPeliculas.mapper;

import org.springframework.stereotype.Component;

import edu.pabloSalgado.practica.plataformaPeliculas.model.Actor;
import edu.pabloSalgado.practica.plataformaPeliculas.model.dto.ActorDTO;
import edu.pabloSalgado.practica.plataformaPeliculas.model.vo.Dni;
import edu.pabloSalgado.practica.plataformaPeliculas.model.vo.Fecha_nacimiento;

@Component
public class ActorMapper {

    public ActorDTO toDto(Actor actor){
        if (actor == null) return null;

        int dniNumero = 0;
        char dniLetra = '\0';
        if (actor.getDni() != null){
            if (actor.getDni().getNumero() != null) dniNumero = actor.getDni().getNumero();
            if (actor.getDni().getLetra() != null) dniLetra = actor.getDni().getLetra();
        }

        int dia = 0, mes = 0,anho = 0;
        if (actor.getFecha_nacimiento() != null) {
            if (actor.getFecha_nacimiento().getDia() != null) dia = actor.getFecha_nacimiento().getDia();
            if (actor.getFecha_nacimiento().getMes() != null) mes = actor.getFecha_nacimiento().getMes();
            if (actor.getFecha_nacimiento().getAnho() != null) anho = actor.getFecha_nacimiento().getAnho();
        }

        return new ActorDTO(
            actor.getNombre(),
            actor.getApellido(),
            dniNumero,
            dniLetra,
            actor.getNacionalidad(),
            dia,
            mes,
            anho,
            actor.isActivo()
        );
    }

    public Actor toEntity(ActorDTO dto){
        if (dto == null) return null;
        Actor actor = new Actor();

        actor.setNombre(dto.nombre());
        actor.setApellido(dto.apellido());

        if (dto.dniNumero() > 0 && dto.dniLetra() != '\0') {
            Dni dni = new Dni(dto.dniNumero(), dto.dniLetra());
            actor.setDni(dni);
        }

        actor.setNacionalidad(dto.nacionalidad());

        if (dto.nacimientoDia() > 0 && dto.nacimientoMes() > 0 && dto.nacimientoAnho() > 0) {
            Fecha_nacimiento fn = new Fecha_nacimiento(dto.nacimientoDia(), dto.nacimientoMes(), dto.nacimientoAnho());
            actor.setFecha_nacimiento(fn);
        }

        actor.setActivo(dto.activo());

        return actor;
    }
}
