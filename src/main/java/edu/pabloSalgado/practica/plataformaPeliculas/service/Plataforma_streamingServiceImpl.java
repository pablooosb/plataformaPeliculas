package edu.pabloSalgado.practica.plataformaPeliculas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import edu.pabloSalgado.practica.plataformaPeliculas.model.Plataforma_streaming;
import edu.pabloSalgado.practica.plataformaPeliculas.model.dto.Plataforma_streamingDTO;
import edu.pabloSalgado.practica.plataformaPeliculas.model.enums.Pais;
import edu.pabloSalgado.practica.plataformaPeliculas.repository.Plataforma_streamingRepository;
import edu.pabloSalgado.practica.plataformaPeliculas.service.interfaces.IPlataforma_streamingService;

@Service
public class Plataforma_streamingServiceImpl implements IPlataforma_streamingService{
    private Plataforma_streamingRepository plataforma_streamingRepo;

    public Plataforma_streamingServiceImpl(Plataforma_streamingRepository plataforma_streamingRepo){
        this.plataforma_streamingRepo = plataforma_streamingRepo;
    }

    @Override
    public Plataforma_streaming addPlataformaStreaming(Plataforma_streamingDTO dto){
        Plataforma_streaming plataforma_streaming = new Plataforma_streaming();

        plataforma_streaming.setNombre(dto.nombre());

        Pais pais = Pais.valueOf(dto.pais().toUpperCase());
        plataforma_streaming.setPais(pais);

        return plataforma_streamingRepo.save(plataforma_streaming);
    }

    @Override
    public List<Plataforma_streaming> showAllPlataformasStreaming(){
        return plataforma_streamingRepo.findAll();
    }

    @Override
    public Plataforma_streaming showPlataformaStreamingById(Long id){
        Optional<Plataforma_streaming> op = plataforma_streamingRepo.findById(id);
        if (op.isPresent()){
            return op.get();
        }
        return null;
    }

    @Override
    public Plataforma_streaming updatePlataformaStreaming(Plataforma_streaming plataforma_streaming){
        Plataforma_streaming actual = plataforma_streamingRepo.findById(plataforma_streaming.getPlataforma_streaming_id()).orElseThrow(() -> new RuntimeException("Plataforma de streaming no encontrado con id " + plataforma_streaming.getPlataforma_streaming_id()));

        actual.setNombre(plataforma_streaming.getNombre());

        actual.setPais(plataforma_streaming.getPais());

        return plataforma_streamingRepo.save(actual);
    }

    @Override
    public void deletePlataformaStreamingById(Long id){
        if (!plataforma_streamingRepo.existsById(id)){
            throw new IllegalArgumentException("Plataforma de streaming con id " + id + " no encontrada");
        } plataforma_streamingRepo.deleteById(id);
    }

    @Override
    public List<Plataforma_streaming> findPlataformasStreamingByPais(){
        return plataforma_streamingRepo.findPlataformasStreamingByPais(Pais.USA);
    }
}
