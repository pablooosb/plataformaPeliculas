package edu.pabloSalgado.practica.plataformaPeliculas.model.dto;

public record ActorDTO(
    String nombre,
    String apellido,
    int dniNumero,
    char dniLetra,
    String nacionalidad,
    int nacimientoDia,
    int nacimientoMes,
    int nacimientoAnho,
    boolean activo
) {}
