package edu.pabloSalgado.practica.plataformaPeliculas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import edu.pabloSalgado.practica.plataformaPeliculas.model.Director;
import edu.pabloSalgado.practica.plataformaPeliculas.model.dto.DirectorDTO;
import edu.pabloSalgado.practica.plataformaPeliculas.model.vo.Dni;
import edu.pabloSalgado.practica.plataformaPeliculas.model.vo.Fecha_nacimiento;
import edu.pabloSalgado.practica.plataformaPeliculas.repository.DirectorRepository;
import edu.pabloSalgado.practica.plataformaPeliculas.service.interfaces.IDirectorService;

@Service
public class DirectorServiceImpl implements IDirectorService{
    private DirectorRepository directorRepo;

    public DirectorServiceImpl(DirectorRepository directorRepo){
        this.directorRepo  = directorRepo;
    }

    @Override
    public Director addDirector(DirectorDTO dto){
        Director director = new Director();

        director.setNombre(dto.nombre());
        director.setApellido(dto.apellido());

        Dni dni = new Dni(dto.dniNumero(), dto.dniLetra());
        director.setDni(dni);

        director.setNacionalidad(dto.nacionalidad());
        director.setActivo(dto.activo());

        Fecha_nacimiento fecha_nacimiento = new Fecha_nacimiento(dto.nacimientoDia(), dto.nacimientoMes(), dto.nacimientoAnho());
        director.setFecha_nacimiento(fecha_nacimiento);

        return directorRepo.save(director);
    }

    @Override
    public List<Director> showAllDirectors(){
        return directorRepo.findAll();
    }

    @Override
    public Director showDirectorById(Long id){
        Optional<Director> op = directorRepo.findById(id);
        if (op.isPresent()){
            return op.get();
        }
        return null;
    }

    @Override
    public Director updateDirectorById(Long id, DirectorDTO dto){
        Director director = directorRepo.findById(id).orElseThrow(() -> new RuntimeException("Director no encontrado con id " + id));

        director.setNombre(dto.nombre());
        director.setApellido(dto.apellido());

        Dni dni = new Dni(dto.dniNumero(), dto.dniLetra());
        director.setDni(dni);

        director.setNacionalidad(dto.nacionalidad());
        director.setActivo(dto.activo());

        Fecha_nacimiento fecha_nacimiento = new Fecha_nacimiento(dto.nacimientoDia(), dto.nacimientoMes(), dto.nacimientoAnho());
        director.setFecha_nacimiento(fecha_nacimiento);

        return directorRepo.save(director);
    }

    @Override
    public void deleteDirectorById(Long id){
        if (!directorRepo.existsById(id)){
            throw new IllegalArgumentException("Director con id " + id + " no encontrado");
        } directorRepo.deleteById(id);
    }
}
