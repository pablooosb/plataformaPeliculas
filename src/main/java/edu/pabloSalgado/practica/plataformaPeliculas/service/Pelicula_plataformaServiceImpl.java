package edu.pabloSalgado.practica.plataformaPeliculas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import edu.pabloSalgado.practica.plataformaPeliculas.model.Pelicula;
import edu.pabloSalgado.practica.plataformaPeliculas.model.Pelicula_plataforma;
import edu.pabloSalgado.practica.plataformaPeliculas.model.Plataforma_streaming;
import edu.pabloSalgado.practica.plataformaPeliculas.model.dto.Pelicula_plataformaDTO;
import edu.pabloSalgado.practica.plataformaPeliculas.model.enums.Calidad;
import edu.pabloSalgado.practica.plataformaPeliculas.model.vo.Money;
import edu.pabloSalgado.practica.plataformaPeliculas.repository.Pelicula_plataformaRepository;
import edu.pabloSalgado.practica.plataformaPeliculas.service.interfaces.IPelicula_plataformaService;

@Service
public class Pelicula_plataformaServiceImpl implements IPelicula_plataformaService{
    private Pelicula_plataformaRepository pelicula_plataformaRepo;

    public Pelicula_plataformaServiceImpl(Pelicula_plataformaRepository pelicula_plataformaRepo){
        this.pelicula_plataformaRepo = pelicula_plataformaRepo;
    }

    @Override
    public Pelicula_plataforma addPeliculaPlataforma(Pelicula_plataformaDTO dto){
        Pelicula_plataforma pelicula_plataforma = new Pelicula_plataforma();

        Pelicula pelicula = new Pelicula();
        pelicula.setPelicula_id(dto.pelicula_id());
        pelicula_plataforma.setPelicula(pelicula);

        Plataforma_streaming plataforma_streaming = new Plataforma_streaming();
        plataforma_streaming.setPlataforma_streaming_id(dto.plataforma_streaming_id());
        pelicula_plataforma.setPlataforma_streaming(plataforma_streaming);
        
        pelicula_plataforma.setFecha_estreno_en_plataforma(dto.fecha_estreno_en_plataforma());

        Money alquiler = new Money(dto.precioAlquiler(), dto.monedaAlquiler());
        pelicula_plataforma.setAlquiler(alquiler);

        Money compra = new Money(dto.precioCompra(), dto.monedaCompra());
        pelicula_plataforma.setCompra(compra);

        Calidad calidad = Calidad.valueOf(dto.calidad().toUpperCase());
        pelicula_plataforma.setCalidad(calidad);

        return pelicula_plataformaRepo.save(pelicula_plataforma);
    }

    @Override
    public List<Pelicula_plataforma> showAllPeliculasPlataforma(){
        return pelicula_plataformaRepo.findAll();
    }

    @Override
    public Pelicula_plataforma showPeliculaPlataformaById(Long id){
        Optional<Pelicula_plataforma> op = pelicula_plataformaRepo.findById(id);
        if (op.isPresent()){
            return op.get();
        }
        return null;
    }

    @Override
    public Pelicula_plataforma updatePeliculaPlataformaById(Long id, Pelicula_plataformaDTO dto){
        Pelicula_plataforma pelicula_plataforma = pelicula_plataformaRepo.findById(id).orElseThrow(() -> new RuntimeException("Pelicula plataforma no encontrado con id " + id));

        Pelicula pelicula = new Pelicula();
        pelicula.setPelicula_id(dto.pelicula_id());
        pelicula_plataforma.setPelicula(pelicula);

        Plataforma_streaming plataforma_streaming = new Plataforma_streaming();
        plataforma_streaming.setPlataforma_streaming_id(dto.plataforma_streaming_id());
        pelicula_plataforma.setPlataforma_streaming(plataforma_streaming);
        
        pelicula_plataforma.setFecha_estreno_en_plataforma(dto.fecha_estreno_en_plataforma());

        Money alquiler = new Money(dto.precioAlquiler(), dto.monedaAlquiler());
        pelicula_plataforma.setAlquiler(alquiler);

        Money compra = new Money(dto.precioCompra(), dto.monedaCompra());
        pelicula_plataforma.setCompra(compra);

        Calidad calidad = Calidad.valueOf(dto.calidad().toUpperCase());
        pelicula_plataforma.setCalidad(calidad);

        return pelicula_plataformaRepo.save(pelicula_plataforma);
    }

    @Override
    public void deletePeliculaPlataformaById(Long id){
        if (!pelicula_plataformaRepo.existsById(id)){
            throw new IllegalArgumentException("Pelicula plataforma con id " + id + " no encontrada");
        } pelicula_plataformaRepo.deleteById(id);
    }

    @Override
    public List<Long> findPeliculasPrecioCompraMenorQue(Double precio) {
        return pelicula_plataformaRepo.findPeliculasIdPrecioCompraMenorQue(precio);
    }
}
