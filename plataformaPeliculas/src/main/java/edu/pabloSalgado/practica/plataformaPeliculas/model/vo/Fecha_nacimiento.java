package edu.pabloSalgado.practica.plataformaPeliculas.model.vo;

import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public final class Fecha_nacimiento {

    private Integer dia;
    private Integer mes;
    private Integer anho;

    public Fecha_nacimiento(Integer dia, Integer mes, Integer anho) {
        if (dia == null || mes == null || anho == null) {
            throw new IllegalArgumentException("Día, mes y año no pueden ser nulos");
        }
        if (dia <= 0 || mes <= 0 || anho <= 0) {
            throw new IllegalArgumentException("Día, mes y año deben ser mayores que 0");
        }
        if (mes > 12) {
            throw new IllegalArgumentException("Mes inválido: " + mes);
        }

        int maxDias = diasMaximosDelMes(mes, anho);
        if (dia > maxDias) {
            throw new IllegalArgumentException("Día inválido para el mes: " + dia + " (máx " + maxDias + ")");
        }

        this.dia = dia;
        this.mes = mes;
        this.anho = anho;
    }

    public Fecha_nacimiento() {
        this.dia = null;
        this.mes = null;
        this.anho = null;
    }

    private int diasMaximosDelMes(int mes, int anho) {
        return switch (mes) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> (esBisiesto(anho) ? 29 : 28);
            default -> 0;
        };
    }

    private boolean esBisiesto(int anho) {
        return (anho % 4 == 0 && anho % 100 != 0) || (anho % 400 == 0);
    }

    public Integer getDia() {
        return dia;
    }

    public Integer getMes() {
        return mes;
    }

    public Integer getAnho() {
        return anho;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fecha_nacimiento that = (Fecha_nacimiento) o;
        return Objects.equals(dia, that.dia) && Objects.equals(mes, that.mes) && Objects.equals(anho, that.anho);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dia, mes, anho);
    }

    @Override
    public String toString() {
        return String.format("%02d-%02d-%04d", dia, mes, anho);
    }
}