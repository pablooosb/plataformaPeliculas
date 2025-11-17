package edu.pabloSalgado.practica.plataformaPeliculas.model;

import java.util.List;

import edu.pabloSalgado.practica.plataformaPeliculas.model.vo.Dni;
import edu.pabloSalgado.practica.plataformaPeliculas.model.vo.Fecha_nacimiento;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "directores")
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long actor_id;
    @Column(length = 100, nullable = false)
    private String nombre;
    @Column(length = 100, nullable = false)
    private String apellido;
    private Dni dni;
    @Column(length = 50, nullable = false)
    private String nacionalidad;
    private Fecha_nacimiento fecha_nacimiento;
    @Column
    private boolean activo;

    @OneToMany(mappedBy = "director", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Pelicula> peliculas;
}
