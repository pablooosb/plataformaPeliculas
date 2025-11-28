package edu.pabloSalgado.practica.plataformaPeliculas.model.mapper;

import edu.pabloSalgado.practica.plataformaPeliculas.model.Director;
import edu.pabloSalgado.practica.plataformaPeliculas.model.Pelicula;
import edu.pabloSalgado.practica.plataformaPeliculas.model.dto.PeliculaDTO;
import edu.pabloSalgado.practica.plataformaPeliculas.model.enums.Edad_minima;
import edu.pabloSalgado.practica.plataformaPeliculas.model.enums.Genero;

public class PeliculaMapper {
    public PeliculaDTO toDto(Pelicula pelicula){
        if (pelicula == null) return null;

        String genero = "";
        if (pelicula.getGenero() != null){
            genero = pelicula.getGenero().name();
        }

        String edad_minima = "";
        if (pelicula.getEdad_minima() != null){
            genero = pelicula.getEdad_minima().name();
        }

        Long director_id = null;
        if (pelicula.getDirector() != null){
            director_id = pelicula.getDirector().getDirector_id();
        }

        return new PeliculaDTO(
            pelicula.getTitulo(),
            pelicula.getDuracion(),
            pelicula.getFecha_estreno(),
            genero,
            edad_minima,
            director_id
        );
    }

    public Pelicula toEntity(PeliculaDTO dto){
        if (dto == null) return null;
        Pelicula pelicula = new Pelicula();
        
        pelicula.setTitulo(dto.titulo());
        pelicula.setDuracion(dto.duracion());
        pelicula.setFecha_estreno(dto.fecha_estreno());

        if (dto.genero() != null && !dto.genero().isBlank()){
            pelicula.setGenero(Genero.valueOf(dto.genero().toUpperCase()));
        }

        if (dto.edad_minima() != null && !dto.genero().isBlank()){
            pelicula.setEdad_minima(Edad_minima.valueOf(dto.edad_minima().toUpperCase()));
        }

        Director director = new Director();
        director.setDirector_id(dto.director_id());
        pelicula.setDirector(director);

        return pelicula;
    }
}
