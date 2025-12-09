package edu.pabloSalgado.practica.plataformaPeliculas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pabloSalgado.practica.plataformaPeliculas.model.Plataforma_streaming;
import edu.pabloSalgado.practica.plataformaPeliculas.model.dto.Plataforma_streamingDTO;
import edu.pabloSalgado.practica.plataformaPeliculas.model.mapper.Plataforma_streamingMapper;
import edu.pabloSalgado.practica.plataformaPeliculas.service.interfaces.IPlataforma_streamingService;

@RestController
@RequestMapping("/plataformasStreaming")
public class PlataformaStreamingController {
    @Autowired
    private IPlataforma_streamingService plataforma_streamingService;
    @Autowired
    private Plataforma_streamingMapper plataforma_streamingMapper;

    @GetMapping
    public List<Plataforma_streaming> listarPlataformasStreaming(){
        return plataforma_streamingService.showAllPlataformasStreaming();
    }

    @PostMapping("/update")
    public Plataforma_streamingDTO updatePlataformaStreaming(@RequestBody Plataforma_streamingDTO plataforma_streamingDTO){
        Plataforma_streaming plataforma_streaming = plataforma_streamingMapper.toEntity(plataforma_streamingDTO);
        Plataforma_streaming updated = plataforma_streamingService.updatePlataformaStreaming(plataforma_streaming);
        return plataforma_streamingMapper.todDto(updated);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePlataformaStreaming(@PathVariable("id") Long id){
        try {
            plataforma_streamingService.deletePlataformaStreamingById(id);
        } catch (Exception e){
            System.err.println("Error al eliminar la plataforma de streaming con id " + id + ": " + e.getMessage());
            throw e;
        }
    }

    // Endpoint para obtener las plataformas de streaming de USA
    @GetMapping("/usa")
    public List<Plataforma_streaming> listarPlataformasUSA() {
        return plataforma_streamingService.findPlataformasStreamingByPais();
    }

}
