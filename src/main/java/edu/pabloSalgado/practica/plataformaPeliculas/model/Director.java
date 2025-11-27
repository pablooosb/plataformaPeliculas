package edu.pabloSalgado.practica.plataformaPeliculas.model;

import java.util.Set;

import edu.pabloSalgado.practica.plataformaPeliculas.model.vo.Dni;
import edu.pabloSalgado.practica.plataformaPeliculas.model.vo.Fecha_nacimiento;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
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
    private Long director_id;
    @Column(length = 100, nullable = false)
    private String nombre;
    @Column(length = 100, nullable = false)
    private String apellido;
    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "numero", column = @Column(name = "dni_numero")),
        @AttributeOverride(name = "letra", column = @Column(name = "dni_letra"))
    })
    private Dni dni;
    @Column(length = 50, nullable = false)
    private String nacionalidad;
    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "dia", column = @Column(name = "fecha_nacimiento_dia")),
        @AttributeOverride(name = "mes", column = @Column(name = "fecha_nacimiento_mes")),
        @AttributeOverride(name = "anho", column = @Column(name = "fecha_nacimiento_anho"))
    })
    private Fecha_nacimiento fecha_nacimiento;
    @Column
    private boolean activo;

    @OneToMany(mappedBy = "director", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Pelicula> peliculas;

    public Long getDirector_id() {
        return director_id;
    }

    public void setDirector_id(Long director_id) {
        this.director_id = director_id;
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

    public Set<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(Set<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

    @Override
    public String toString() {
        return "Director [director_id=" + director_id + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni
                + ", nacionalidad=" + nacionalidad + ", fecha_nacimiento=" + fecha_nacimiento + ", activo=" + activo
                + ", peliculas=" + peliculas + "]";
    }
}
