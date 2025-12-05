package edu.pabloSalgado.practica.plataformaPeliculas.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record Pelicula_plataformaDTO(
    Long pelicula_id,
    Long plataforma_streaming_id,
    LocalDate fecha_estreno_en_plataforma,
    BigDecimal precioAlquiler,
    String monedaAlquiler,
    BigDecimal precioCompra,
    String monedaCompra,
    String calidad
) {}