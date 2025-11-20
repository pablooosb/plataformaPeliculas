package edu.pabloSalgado.practica.plataformaPeliculas.model.vo;

import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public final class Dni {

    private static final String LETTERS = "TRWAGMYFPDXBNJZSQVHLCKE";

    private Integer numero;
    private Character letra;

    public Dni(Integer numero, Character letra) {
        if (numero == null) throw new IllegalArgumentException("El número de DNI no puede ser nulo");
        if (letra == null) throw new IllegalArgumentException("La letra del DNI no puede ser nula");
        if (numero < 0) throw new IllegalArgumentException("El número de DNI no puede ser negativo");

        char upper = Character.toUpperCase(letra);
        if (LETTERS.indexOf(upper) < 0) {
            throw new IllegalArgumentException("Letra de DNI no aceptada: " + letra);
        }

        int idx = numero % 23;
        char expected = LETTERS.charAt(idx);
        if (expected != upper) {
            throw new IllegalArgumentException("La letra del DNI no concuerda con el número (esperada '" + expected + "')");
        }

        this.numero = numero;
        this.letra = upper;
    }

    public Dni() {
        this.numero = null;
        this.letra = null;
    }

    public Integer getNumero() {
        return numero;
    }

    public Character getLetra() {
        return letra;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dni dni = (Dni) o;
        return Objects.equals(numero, dni.numero) && Objects.equals(letra, dni.letra);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, letra);
    }

    @Override
    public String toString() {
        return numero + String.valueOf(letra);
    }
}