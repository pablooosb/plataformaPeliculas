package edu.pabloSalgado.practica.plataformaPeliculas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "plataformas_streaming")
public class Plataforma_streaming {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long plataforma_streaming_id;
    @Column(length=100, nullable = false)
    private String nombre;
    @Column(length=100, nullable = false)
    private String pais;
}
