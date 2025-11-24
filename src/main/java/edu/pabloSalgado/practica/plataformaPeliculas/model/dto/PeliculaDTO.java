package edu.pabloSalgado.practica.plataformaPeliculas.model.dto;

import java.time.LocalDate;

public record PeliculaDTO(
    String titulo,
    int duracion,
    LocalDate fecha_estreno,
    String genero,
    int edad_recomendada,
    Long director_id
) {}