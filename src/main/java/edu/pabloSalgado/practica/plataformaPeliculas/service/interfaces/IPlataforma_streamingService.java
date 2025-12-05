package edu.pabloSalgado.practica.plataformaPeliculas.service.interfaces;

import java.util.List;

import edu.pabloSalgado.practica.plataformaPeliculas.model.Plataforma_streaming;
import edu.pabloSalgado.practica.plataformaPeliculas.model.dto.Plataforma_streamingDTO;

public interface IPlataforma_streamingService {
    // añadir plataforma
    Plataforma_streaming addPlataformaStreaming(Plataforma_streamingDTO dto);
    // Obtener todas las plataformas
    List<Plataforma_streaming> showAllPlataformasStreaming();
    // obtener plataforma por id
    Plataforma_streaming showPlataformaStreamingById(Long id);
    // Actualizar plataformas por id
    Plataforma_streaming updatePlataformaStreamingById(Long id, Plataforma_streamingDTO plataforma_streamingDTO);
    // Eliminar plataforma por id
    void deletePlataformaStreamingById(Long id);
}
