package edu.pabloSalgado.practica.plataformaPeliculas.model;

import java.time.LocalDate;

import edu.pabloSalgado.practica.plataformaPeliculas.model.enums.Calidad;
import edu.pabloSalgado.practica.plataformaPeliculas.model.vo.Money;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
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
    private Pelicula pelicula_id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plataforma_streaming_id")
    private Plataforma_streaming plataforma_streaming_id;
    @Column(name = "fecha_estreno_en_plataforma", nullable = false)
    private LocalDate fecha_estreno_en_plataforma;
    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "amount", column = @Column(name = "precio", nullable = false, scale = 2)),
        @AttributeOverride(name = "currency", column = @Column(name = "moneda", nullable = false, length = 3))
    })
    private Money precio_alquiler;
    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "amount", column = @Column(name = "precio", nullable = false, scale = 2)),
        @AttributeOverride(name = "currency", column = @Column(name = "moneda", nullable = false, length = 3))
    })
    private Money precio_compra;
    @Column(name = "calidad")
    private Calidad calidad;
}
