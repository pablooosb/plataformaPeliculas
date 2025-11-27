package edu.pabloSalgado.practica.plataformaPeliculas.model;

import edu.pabloSalgado.practica.plataformaPeliculas.model.enums.Pais;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
    @Enumerated(EnumType.STRING)
    @Column(length=100, nullable = false)
    private Pais pais;
    
    public Plataforma_streaming() {
    }

    public Plataforma_streaming(Long plataforma_streaming_id, String nombre, Pais pais) {
        this.plataforma_streaming_id = plataforma_streaming_id;
        this.nombre = nombre;
        this.pais = pais;
    }

    public Long getPlataforma_streaming_id() {
        return plataforma_streaming_id;
    }

    public void setPlataforma_streaming_id(Long plataforma_streaming_id) {
        this.plataforma_streaming_id = plataforma_streaming_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Plataforma_streaming [plataforma_streaming_id=" + plataforma_streaming_id + ", nombre=" + nombre
                + ", pais=" + pais + "]";
    }
}
