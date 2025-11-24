package edu.pabloSalgado.practica.plataformaPeliculas.model.mapper;

import edu.pabloSalgado.practica.plataformaPeliculas.model.Plataforma_streaming;
import edu.pabloSalgado.practica.plataformaPeliculas.model.dto.Plataforma_streamingDTO;
import edu.pabloSalgado.practica.plataformaPeliculas.model.enums.Pais;

public class Plataforma_streamingMapper {
    public Plataforma_streamingDTO todDto(Plataforma_streaming plataforma_streaming){
        if (plataforma_streaming == null) return null;

        String pais = "";
        if (plataforma_streaming.getPais() != null){
            pais = plataforma_streaming.getPais().name();
        }

        return new Plataforma_streamingDTO(
            plataforma_streaming.getNombre(),
            pais
        );
    }

    public Plataforma_streaming toEntity(Plataforma_streamingDTO dto){
        if (dto == null) return null;
        Plataforma_streaming plataforma_streaming = new Plataforma_streaming();

        plataforma_streaming.setNombre(dto.nombre());
        if (dto.pais() != null && !dto.pais().isBlank()) {
            plataforma_streaming.setPais(Pais.valueOf(dto.pais().toUpperCase()));
        }

        return plataforma_streaming;
    }
}
