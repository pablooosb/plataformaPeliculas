package edu.pabloSalgado.practica.plataformaPeliculas.mapper;

import org.springframework.stereotype.Component;

import edu.pabloSalgado.practica.plataformaPeliculas.model.Director;
import edu.pabloSalgado.practica.plataformaPeliculas.model.dto.DirectorDTO;
import edu.pabloSalgado.practica.plataformaPeliculas.model.vo.Dni;
import edu.pabloSalgado.practica.plataformaPeliculas.model.vo.Fecha_nacimiento;

@Component
public class DirectorMapper {
    public DirectorDTO toDto(Director director){
        if (director == null) return null;

        int dniNumero = 0;
        char dniLetra = '\0';
        if (director.getDni() != null){
            if (director.getDni().getNumero() != null) dniNumero = director.getDni().getNumero();
            if (director.getDni().getLetra() != null) dniLetra = director.getDni().getLetra();
        }

        int dia = 0, mes = 0,anho = 0;
        if (director.getFecha_nacimiento() != null) {
            if (director.getFecha_nacimiento().getDia() != null) dia = director.getFecha_nacimiento().getDia();
            if (director.getFecha_nacimiento().getMes() != null) mes = director.getFecha_nacimiento().getMes();
            if (director.getFecha_nacimiento().getAnho() != null) anho = director.getFecha_nacimiento().getAnho();
        }

        return new DirectorDTO(
            director.getNombre(),
            director.getApellido(),
            dniNumero,
            dniLetra,
            director.getNacionalidad(),
            dia,
            mes,
            anho,
            director.isActivo()
        );
    }

    public Director toEntity(DirectorDTO dto){
        if (dto == null) return null;
        Director director = new Director();

        director.setNombre(dto.nombre());
        director.setApellido(dto.apellido());

        if (dto.dniNumero() > 0 && dto.dniLetra() != '\0') {
            Dni dni = new Dni(dto.dniNumero(), dto.dniLetra());
            director.setDni(dni);
        }

        director.setNacionalidad(dto.nacionalidad());

        if (dto.nacimientoDia() > 0 && dto.nacimientoMes() > 0 && dto.nacimientoAnho() > 0) {
            Fecha_nacimiento fn = new Fecha_nacimiento(dto.nacimientoDia(), dto.nacimientoMes(), dto.nacimientoAnho());
            director.setFecha_nacimiento(fn);
        }

        director.setActivo(dto.activo());

        return director;
    }
}
