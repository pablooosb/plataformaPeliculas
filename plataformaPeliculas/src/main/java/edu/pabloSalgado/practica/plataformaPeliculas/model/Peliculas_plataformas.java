package edu.pabloSalgado.practica.plataformaPeliculas.model;

import java.time.LocalDate;

import edu.pabloSalgado.practica.plataformaPeliculas.enums.Calidad;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "peliculas_plataformas")
public class Peliculas_plataformas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long peliculas_plataformas_id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pelicula_id")
    private Pelicula pelicula;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plataforma_streaming_id")
    private Plataforma_streaming plataforma_streaming;
    @Column(name = "fecha_estreno_en_plataforma", nullable = false)
    private LocalDate fecha_estreno_en_plataforma;
    @Column(name = "precio_alquiler")
    private Double precio_alquiler;
    @Column(name = "precio_compra")
    private Double precio_compra;
    @Column(name = "calidad")
    private Calidad calidad;
}
