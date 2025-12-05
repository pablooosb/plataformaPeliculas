package edu.pabloSalgado.practica.plataformaPeliculas.model;

import java.time.LocalDate;
import java.util.Set;

import edu.pabloSalgado.practica.plataformaPeliculas.model.enums.Edad_minima;
import edu.pabloSalgado.practica.plataformaPeliculas.model.enums.Genero;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
    @Enumerated(EnumType.STRING)
    @Column
    private Genero genero;
    @Enumerated(EnumType.STRING)
    @Column
    private Edad_minima edad_minima;

    @ManyToOne
    @JoinColumn(name = "director_id", nullable = false)
    private Long director_id;

    @ManyToMany(mappedBy = "peliculas")
    private Set<Actor> actores;

    public Pelicula() {
    }

    public Pelicula(Long pelicula_id, String titulo, int duracion, LocalDate fecha_estreno, Genero genero,
            Edad_minima edad_minima, Long director_id, Set<Actor> actores) {
        this.pelicula_id = pelicula_id;
        this.titulo = titulo;
        this.duracion = duracion;
        this.fecha_estreno = fecha_estreno;
        this.genero = genero;
        this.edad_minima = edad_minima;
        this.director_id = director_id;
        this.actores = actores;
    }

    public Long getPelicula_id() {
        return pelicula_id;
    }

    public void setPelicula_id(Long pelicula_id) {
        this.pelicula_id = pelicula_id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public LocalDate getFecha_estreno() {
        return fecha_estreno;
    }

    public void setFecha_estreno(LocalDate fecha_estreno) {
        this.fecha_estreno = fecha_estreno;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Edad_minima getEdad_minima() {
        return edad_minima;
    }

    public void setEdad_minima(Edad_minima edad_minima) {
        this.edad_minima = edad_minima;
    }

    public Long getDirector_id() {
        return director_id;
    }

    public void setDirector_id(Long director_id) {
        this.director_id = director_id;
    }

    public Set<Actor> getActores() {
        return actores;
    }

    public void setActores(Set<Actor> actores) {
        this.actores = actores;
    }

    @Override
    public String toString() {
        return "Pelicula [pelicula_id=" + pelicula_id + ", titulo=" + titulo + ", duracion=" + duracion
                + ", fecha_estreno=" + fecha_estreno + ", genero=" + genero + ", edad_minima=" + edad_minima
                + ", director_id=" + director_id + ", actores=" + actores + "]";
    }
}
