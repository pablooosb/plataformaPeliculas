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
    private Dni dni;
    @Column(length = 50, nullable = false)
    private String nacionalidad;
    private Fecha_nacimiento fecha_nacimiento;
    @Column
    private boolean activo;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "actores_peliculas",
        joinColumns = @JoinColumn(name = "actor_id"),
        inverseJoinColumns = @JoinColumn(name = "pelicula_id") )
    private List<Pelicula> peliculas;

    public Actor() {
    }

    

    public Actor(Long actor_id, String nombre, String apellido, Dni dni, String nacionalidad, Fecha_nacimiento fecha_nacimiento, boolean activo, List<Pelicula> peliculas) {
        this.actor_id = actor_id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.nacionalidad = nacionalidad;
        this.fecha_nacimiento = fecha_nacimiento;
        this.activo = activo;
        this.peliculas = peliculas;
    }



    public Long getActor_id() {
        return actor_id;
    }

    public void setActor_id(Long actor_id) {
        this.actor_id = actor_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Dni getDni() {
        return dni;
    }

    public void setDni(Dni dni) {
        this.dni = dni;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Fecha_nacimiento getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Fecha_nacimiento fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(List<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

    @Override
    public String toString() {
        return "Actor [actor_id=" + actor_id + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni
                + ", nacionalidad=" + nacionalidad + ", fecha_nacimiento=" + fecha_nacimiento + ", activo=" + activo
                + ", peliculas=" + peliculas + "]";
    }
}
