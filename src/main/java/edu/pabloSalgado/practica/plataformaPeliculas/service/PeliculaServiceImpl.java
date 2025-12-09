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

        Edad_minima edadMinima = Edad_minima.valueOf(dto.edadMinima().toUpperCase());
        pelicula.setEdad_minima(edadMinima);

        Director director = new Director();
        director.setDirector_id(dto.director_id());
        pelicula.setDirector(director);

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
    public Pelicula updatePelicula(Pelicula pelicula){
        Pelicula actual = peliculaRepo.findById(pelicula.getPelicula_id()).orElseThrow(() -> new RuntimeException("Pelicula no encontrado con id " + pelicula.getPelicula_id()));

        actual.setTitulo(pelicula.getTitulo());
        actual.setDuracion(pelicula.getDuracion());
        actual.setFecha_estreno(pelicula.getFecha_estreno());

        actual.setGenero(pelicula.getGenero());

        actual.setEdad_minima(pelicula.getEdad_minima());

        Director director = new Director();
        director.setDirector_id(pelicula.getDirector().getDirector_id());
        actual.setDirector(director);

        return peliculaRepo.save(actual);
    }

    @Override
    public void deletePeliculaById(Long id){
        if (!peliculaRepo.existsById(id)){
            throw new IllegalArgumentException("Pelicula con id " + id + " no encontrado");
        } peliculaRepo.deleteById(id);
    }

    @Override
    public List<Pelicula> getPeliculasAptas12(){
        return peliculaRepo.getPeliculasAptas12();
    }
}
