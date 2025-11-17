package edu.pabloSalgado.practica.plataformaPeliculas.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Edad_recomendada {
    TRES("3"),
    SIETE("7"),
    DOCE("12"),
    DIECISEIS("16"),
    DIECIOCHO("18");

    private final String eREnBBDD;

    // Constructor privado para el enum
    Edad_recomendada(String edad) {
        this.eREnBBDD = edad;
    }

    // Getter que usará JPA y Jackson (para el JSON)
    @JsonValue
    public String getEdadEnBBDD() {
        return eREnBBDD;
    }

    // Método estático para encontrar el enum a partir del valor de la BBDD
    public static Edad_recomendada fromEdadEnBBDD(String edad) {
        for (Edad_recomendada eR : values()) {
            if (eR.eREnBBDD.equals(edad)) {
                return eR;
            }
        }
        throw new IllegalArgumentException("Valoración desconocida: " + edad);
    }
}
