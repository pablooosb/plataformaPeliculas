package edu.pabloSalgado.practica.plataformaPeliculas.model;

import java.time.LocalDate;
import java.util.Set;

import edu.pabloSalgado.practica.plataformaPeliculas.model.enums.Edad_recomendada;
import edu.pabloSalgado.practica.plataformaPeliculas.model.enums.Genero;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
    @Column
    private Genero genero;
    @Column
    private Edad_recomendada edad_recomendada;

    @ManyToOne
    @JoinColumn(name = "director_id", nullable = false)
    private Director director;

    @ManyToMany(mappedBy = "peliculas")
    private Set<Actor> actores;

    public Pelicula() {
    }

    public Pelicula(Long pelicula_id, String titulo, int duracion, LocalDate fecha_estreno, Genero genero,
            Edad_recomendada edad_recomendada, Director director, Set<Actor> actores) {
        this.pelicula_id = pelicula_id;
        this.titulo = titulo;
        this.duracion = duracion;
        this.fecha_estreno = fecha_estreno;
        this.genero = genero;
        this.edad_recomendada = edad_recomendada;
        this.director = director;
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

    public Edad_recomendada getEdad_recomendada() {
        return edad_recomendada;
    }

    public void setEdad_recomendada(Edad_recomendada edad_recomendada) {
        this.edad_recomendada = edad_recomendada;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
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
                + ", fecha_estreno=" + fecha_estreno + ", genero=" + genero + ", edad_recomendada=" + edad_recomendada
                + ", director=" + director + ", actores=" + actores + "]";
    }
}
