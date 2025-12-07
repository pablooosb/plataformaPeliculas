package edu.pabloSalgado.practica.plataformaPeliculas.model.mapper;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import edu.pabloSalgado.practica.plataformaPeliculas.model.Pelicula;
import edu.pabloSalgado.practica.plataformaPeliculas.model.Pelicula_plataforma;
import edu.pabloSalgado.practica.plataformaPeliculas.model.Plataforma_streaming;
import edu.pabloSalgado.practica.plataformaPeliculas.model.dto.Pelicula_plataformaDTO;
import edu.pabloSalgado.practica.plataformaPeliculas.model.enums.Calidad;
import edu.pabloSalgado.practica.plataformaPeliculas.model.vo.Money;

@Component
public class Pelicula_plataformaMapper {

    public Pelicula_plataformaDTO toDto(Pelicula_plataforma pelicula_plataforma){
        if (pelicula_plataforma == null) return null;

        Long peliculaId = (pelicula_plataforma.getPelicula() != null ? pelicula_plataforma.getPelicula().getPelicula_id() : null);

        Long plataforma_streamingId = (pelicula_plataforma.getPlataforma_streaming() != null ? pelicula_plataforma.getPlataforma_streaming().getPlataforma_streaming_id() : null);

        BigDecimal precioAlquiler = BigDecimal.ZERO;
        String monedaAlquiler = null;
        if (pelicula_plataforma.getAlquiler() != null){
            if (pelicula_plataforma.getAlquiler().getAmount() != null) precioAlquiler = pelicula_plataforma.getAlquiler().getAmount();
            if (pelicula_plataforma.getAlquiler().getClass() != null) monedaAlquiler = pelicula_plataforma.getAlquiler().getCurrency();
        }

        BigDecimal precioCompra = BigDecimal.ZERO;
        String monedaCompra = null;
        if (pelicula_plataforma.getCompra() != null){
            if (pelicula_plataforma.getCompra().getAmount() != null) precioCompra = pelicula_plataforma.getCompra().getAmount();
            if (pelicula_plataforma.getCompra().getClass() != null) monedaCompra = pelicula_plataforma.getCompra().getCurrency();
        }

        return new Pelicula_plataformaDTO(  
            peliculaId,
            plataforma_streamingId,
            pelicula_plataforma.getFecha_estreno_en_plataforma(),
            precioAlquiler,
            monedaAlquiler,
            precioCompra,
            monedaCompra,
            pelicula_plataforma.getCalidad().toString());
  
    }

    public Pelicula_plataforma toEntity(Pelicula_plataformaDTO dto){
        if (dto == null) return null;
        Pelicula_plataforma pelicula_plataforma = new Pelicula_plataforma();

        if (dto.pelicula_id() != null){
            Pelicula pelicula = new Pelicula();
            pelicula.setPelicula_id(dto.pelicula_id());
            pelicula_plataforma.setPelicula(pelicula);
        }

        if (dto.plataforma_streaming_id() != null){
            Plataforma_streaming plataforma = new Plataforma_streaming();
            plataforma.setPlataforma_streaming_id(dto.plataforma_streaming_id());
            pelicula_plataforma.setPlataforma_streaming(plataforma);
        }
        
        pelicula_plataforma.setFecha_estreno_en_plataforma(dto.fecha_estreno_en_plataforma());

        if (dto.precioAlquiler().compareTo(BigDecimal.ZERO) > 0 && dto.monedaAlquiler() != null){
            Money money = new Money(dto.precioAlquiler(), dto.monedaAlquiler());
            pelicula_plataforma.setAlquiler(money);
        }
        
        if (dto.precioCompra().compareTo(BigDecimal.ZERO) > 0 && dto.monedaCompra() != null){
            Money money = new Money(dto.precioCompra(), dto.monedaCompra());
            pelicula_plataforma.setCompra(money);
        }

        if (dto.calidad() != null && !dto.calidad().isBlank()){
            pelicula_plataforma.setCalidad(Calidad.valueOf(dto.calidad().toUpperCase()));
        }

        return pelicula_plataforma;
    }
}
