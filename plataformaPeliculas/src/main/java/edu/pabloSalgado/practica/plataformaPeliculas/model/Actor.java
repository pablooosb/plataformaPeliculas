package edu.pabloSalgado.practica.plataformaPeliculas.model;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "actores")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long actor_id;
    @Column(length = 100, nullable = false)
    private String nombre;
    @Column(length = 100, nullable = false)
    private String apellido;
    private String dni;
    @Column(length = 50, nullable = false)
    private String nacionalidad;
    private LocalDate fecha_nacimiento;
    @Column
    private boolean activo;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "actores_peliculas",
        joinColumns = @JoinColumn(name = "actor_id") ,
        inverseJoinColumns = @JoinColumn(name = "pelicula_id") )
    private Set<Pelicula> peliculas;
}
