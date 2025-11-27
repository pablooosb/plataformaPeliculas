package edu.pabloSalgado.practica.plataformaPeliculas.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Edad_recomendada {
    TRES("3"),
    SIETE("7"),
    DOCE("12"),
    DIECISEIS("16"),
    DIECIOCHO("18");

    private final String edadEnBBDD;

    // Constructor privado para el enum
    Edad_recomendada(String edad) {
        this.edadEnBBDD = edad;
    }

    // Getter que usará JPA y Jackson (para el JSON)
    @JsonValue
    public String getEdadEnBBDD() {
        return edadEnBBDD;
    }

    // Método estático para encontrar el enum a partir del valor de la BBDD
    public static Edad_recomendada fromEdadEnBBDD(String edad) {
        for (Edad_recomendada eR : values()) {
            if (eR.edadEnBBDD.equals(edad)) {
                return eR;
            }
        }
        throw new IllegalArgumentException("Edad desconocida: " + edad);
    }
}
