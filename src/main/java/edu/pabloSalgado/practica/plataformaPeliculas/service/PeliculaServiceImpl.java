package edu.pabloSalgado.practica.plataformaPeliculas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import edu.pabloSalgado.practica.plataformaPeliculas.model.Director;
import edu.pabloSalgado.practica.plataformaPeliculas.model.Pelicula;
import edu.pabloSalgado.practica.plataformaPeliculas.model.dto.PeliculaDTO;
import edu.pabloSalgado.practica.plataformaPeliculas.model.enums.Edad_minima;
import edu.pabloSalgado.practica.plataformaPeliculas.model.enums.Genero;
import edu.pabloSalgado.practica.plataformaPeliculas.repository.PeliculaRepository;
import edu.pabloSalgado.practica.plataformaPeliculas.service.interfaces.IPeliculaService;

@Service
public class PeliculaServiceImpl implements IPeliculaService{
    private PeliculaRepository peliculaRepo;

    public PeliculaServiceImpl(PeliculaRepository peliculaRepo){
        this.peliculaRepo = peliculaRepo;
    }

    @Override
    public Pelicula addPelicula(PeliculaDTO dto){
        Pelicula pelicula = new Pelicula();

        pelicula.setTitulo(dto.titulo());
        pelicula.setDuracion(dto.duracion());
        pelicula.setFecha_estreno(dto.fecha_estreno());

        Genero genero = Genero.valueOf(dto.genero().toUpperCase());
        pelicula.setGenero(genero);

        Edad_minima edad_minima = Edad_minima.valueOf(dto.edad_minima().toUpperCase());
        pelicula.setEdad_minima(edad_minima);

        pelicula.setDirector_id(dto.director_id());

        return peliculaRepo.save(pelicula);
    }

    @Override
    public List<Pelicula> showAllPeliculas(){
        return peliculaRepo.findAll();
    }

    @Override
    public Pelicula showPeliculaById(Long id){
        Optional<Pelicula> op = peliculaRepo.findById(id);
        if (op.isPresent()){
            return op.get();
        }
        return null;
    }

    @Override
    public Pelicula updatePeliculaById(Long id, PeliculaDTO dto){
        Pelicula pelicula = peliculaRepo.findById(id).orElseThrow(() -> new RuntimeException("Pelicula no encontrado con id " + id));

        pelicula.setTitulo(dto.titulo());
        pelicula.setDuracion(dto.duracion());
        pelicula.setFecha_estreno(dto.fecha_estreno());

        Genero genero = Genero.valueOf(dto.genero().toUpperCase());
        pelicula.setGenero(genero);

        Edad_minima edad_minima = Edad_minima.valueOf(dto.edad_minima().toUpperCase());
        pelicula.setEdad_minima(edad_minima);

        pelicula.setDirector_id(dto.director_id());

        return peliculaRepo.save(pelicula);
    }

    @Override
    public void deletePeliculaById(Long id){
        if (!peliculaRepo.existsById(id)){
            throw new IllegalArgumentException("Pelicula con id " + id + " no encontrado");
        } peliculaRepo.deleteById(id);
    }
}
