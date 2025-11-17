package edu.pabloSalgado.practica.plataformaPeliculas.model;

import java.time.LocalDate;

import edu.pabloSalgado.practica.plataformaPeliculas.enums.Edad_recomendada;
import edu.pabloSalgado.practica.plataformaPeliculas.enums.Genero;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "peliculas")
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pelicula_id;
    @Column(length=100, nullable = false)
    private String titulo;
    @Column(length = 3, nullable = false)
    private int duracion;
    @Column
    private LocalDate fecha_estreno;
    @Column
    private Genero genero;
    @Column
    private Edad_recomendada edad_recomendada;
}
