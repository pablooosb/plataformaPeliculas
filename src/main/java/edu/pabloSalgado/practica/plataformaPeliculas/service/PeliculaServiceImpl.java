package edu.pabloSalgado.practica.plataformaPeliculas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import edu.pabloSalgado.practica.plataformaPeliculas.model.Pelicula;
import edu.pabloSalgado.practica.plataformaPeliculas.model.dto.PeliculaDTO;
import edu.pabloSalgado.practica.plataformaPeliculas.repository.PeliculaRepository;
import edu.pabloSalgado.practica.plataformaPeliculas.service.interfaces.IPeliculaService;

public class PeliculaServiceImpl implements IPeliculaService{
    @Autowired
    private PeliculaRepository pelicularepo;

    @Override
    public List<Pelicula> obtenerTodasLasPeliculas(){
        return pelicularepo.findAll();
    }

    @Override
    public Pelicula obtenerPeliculaPorId(Long id){
        Optional<Pelicula> op = pelicularepo.findById(id);
        if (op.isPresent()) {
            return op.get();
        }
        return null;
    }

    

    @Override
    public Pelicula actualizarOGuardar(Pelicula pelicula){
        if (pelicula.getPelicula_id() == null) {
            System.out.println("Guardamos " + pelicula + " en la base de datos");
            return pelicularepo.save(pelicula);
        } else{
            if (pelicularepo.existsById(pelicula.getPelicula_id())) {
                System.out.println("Actualizamos la pelicula  " + pelicula + " en la base de datos");
                return pelicularepo.save(pelicula);
            } else{
                System.out.println("No exite ninguna pelicula");
                return null;
            }
        }
    }

    @Override
    public void eliminarPelicula(Long id){
        if (pelicularepo.existsById(id)) {
            pelicularepo.deleteById(id);
        } else{
            throw new RuntimeException("Pelicula no encontrada con id " + id);
        }
    }
}
