package edu.pabloSalgado.practica.plataformaPeliculas.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record Pelicula_plataformaDTO(
    PeliculaDTO pelicula_id,
    Plataforma_streamingDTO plataforma_streaming_id,
    LocalDate fecha_estreno_en_plataforma,
    BigDecimal precioAlquiler,
    String monedaAlquiler,
    BigDecimal precioCompra,
    String monedaCompra,
    String calidad
) {}