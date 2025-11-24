package edu.pabloSalgado.practica.plataformaPeliculas.model.mapper;

import edu.pabloSalgado.practica.plataformaPeliculas.model.Director;
import edu.pabloSalgado.practica.plataformaPeliculas.model.Pelicula;
import edu.pabloSalgado.practica.plataformaPeliculas.model.dto.PeliculaDTO;
import edu.pabloSalgado.practica.plataformaPeliculas.model.enums.Edad_recomendada;
import edu.pabloSalgado.practica.plataformaPeliculas.model.enums.Genero;

public class PeliculaMapper {
    public PeliculaDTO toDto(Pelicula pelicula){
        if (pelicula == null) return null;

        String genero = "";
        if (pelicula.getGenero() != null){
            genero = pelicula.getGenero().name();
        }

        int edad_recomendada = 0;
        if (pelicula.getEdad_recomendada() != null){
            edad_recomendada = pelicula.getEdad_recomendada().ordinal(); // ordinal() para convertir el enum a un int
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
            edad_recomendada,
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

        if (dto.edad_recomendada() >= 0 && dto.edad_recomendada() < Edad_recomendada.values().length){
            pelicula.setEdad_recomendada(Edad_recomendada.values()[dto.edad_recomendada()]);
        }

        Director director = new Director();
        director.setDirector_id(dto.director_id());
        pelicula.setDirector(director);

        return pelicula;
    }
}
