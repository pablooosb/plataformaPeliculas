package edu.pabloSalgado.practica.plataformaPeliculas.model.dto;

import java.time.LocalDate;

public record PeliculaDTO(
    String titulo,
    int duracion,
    LocalDate fecha_estreno,
    String genero,
    String edadMinima,
    Long director_id
) {}