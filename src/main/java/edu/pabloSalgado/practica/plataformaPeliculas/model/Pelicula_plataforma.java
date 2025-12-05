package edu.pabloSalgado.practica.plataformaPeliculas.model;

import java.time.LocalDate;

import edu.pabloSalgado.practica.plataformaPeliculas.model.enums.Calidad;
import edu.pabloSalgado.practica.plataformaPeliculas.model.vo.Money;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "peliculas_plataformas")
public class Pelicula_plataforma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long peliculas_plataformas_id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pelicula_id")
    private Long pelicula_id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plataforma_streaming_id")
    private Long plataforma_streaming_id;
    @Column(name = "fecha_estreno_en_plataforma", nullable = false)
    private LocalDate fecha_estreno_en_plataforma;
    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "amount", column = @Column(name = "precio_alquiler", nullable = false, scale = 2)),
        @AttributeOverride(name = "currency", column = @Column(name = "moneda_alquiler", nullable = false, length = 3))
    })
    private Money alquiler;
    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "amount", column = @Column(name = "precio_compra", nullable = false, scale = 2)),
        @AttributeOverride(name = "currency", column = @Column(name = "moneda_compra", nullable = false, length = 3))
    })
    private Money compra;
    @Enumerated(EnumType.STRING)
    @Column(name = "calidad")
    private Calidad calidad;
    
    public Pelicula_plataforma() {
    }

    public Pelicula_plataforma(Long peliculas_plataformas_id, Long pelicula_id,
            Long plataforma_streaming_id, LocalDate fecha_estreno_en_plataforma, Money alquiler,
            Money compra, Calidad calidad) {
        this.peliculas_plataformas_id = peliculas_plataformas_id;
        this.pelicula_id = pelicula_id;
        this.plataforma_streaming_id = plataforma_streaming_id;
        this.fecha_estreno_en_plataforma = fecha_estreno_en_plataforma;
        this.alquiler = alquiler;
        this.compra = compra;
        this.calidad = calidad;
    }

    public Long getPeliculas_plataformas_id() {
        return peliculas_plataformas_id;
    }

    public void setPeliculas_plataformas_id(Long peliculas_plataformas_id) {
        this.peliculas_plataformas_id = peliculas_plataformas_id;
    }

    public Long getPelicula_id() {
        return pelicula_id;
    }

    public void setPelicula_id(Long pelicula_id) {
        this.pelicula_id = pelicula_id;
    }

    public Long getPlataforma_streaming_id() {
        return plataforma_streaming_id;
    }

    public void setPlataforma_streaming_id(Long plataforma_streaming_id) {
        this.plataforma_streaming_id = plataforma_streaming_id;
    }

    public LocalDate getFecha_estreno_en_plataforma() {
        return fecha_estreno_en_plataforma;
    }

    public void setFecha_estreno_en_plataforma(LocalDate fecha_estreno_en_plataforma) {
        this.fecha_estreno_en_plataforma = fecha_estreno_en_plataforma;
    }

    public Money getAlquiler() {
        return alquiler;
    }

    public void setAlquiler(Money alquiler) {
        this.alquiler = alquiler;
    }

    public Money getCompra() {
        return compra;
    }

    public void setCompra(Money compra) {
        this.compra = compra;
    }

    public Calidad getCalidad() {
        return calidad;
    }

    public void setCalidad(Calidad calidad) {
        this.calidad = calidad;
    }

    @Override
    public String toString() {
        return "Pelicula_plataforma [peliculas_plataformas_id=" + peliculas_plataformas_id + ", pelicula_id="
                + pelicula_id + ", plataforma_streaming_id=" + plataforma_streaming_id
                + ", fecha_estreno_en_plataforma=" + fecha_estreno_en_plataforma + ", alquiler=" + alquiler
                + ", compra=" + compra + ", calidad=" + calidad + "]";
    }
}
