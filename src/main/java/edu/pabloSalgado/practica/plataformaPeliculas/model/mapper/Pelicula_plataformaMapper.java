package edu.pabloSalgado.practica.plataformaPeliculas.model.mapper;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import edu.pabloSalgado.practica.plataformaPeliculas.model.Pelicula_plataforma;
import edu.pabloSalgado.practica.plataformaPeliculas.model.dto.Pelicula_plataformaDTO;
import edu.pabloSalgado.practica.plataformaPeliculas.model.enums.Calidad;
import edu.pabloSalgado.practica.plataformaPeliculas.model.vo.Money;

@Component
public class Pelicula_plataformaMapper {

    public Pelicula_plataformaDTO toDto(Pelicula_plataforma pelicula_plataforma){
        if (pelicula_plataforma == null) return null;

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
            pelicula_plataforma.getPelicula_id(),
            pelicula_plataforma.getPlataforma_streaming_id(),
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

        pelicula_plataforma.setPelicula_id(dto.pelicula_id());
        pelicula_plataforma.setPlataforma_streaming_id(dto.plataforma_streaming_id());
        pelicula_plataforma.setFecha_estreno_en_plataforma(dto.fecha_estreno_en_plataforma());

        // if (dto.dniNumero() > 0 && dto.dniLetra() != '\0') {
        //     Dni dni = new Dni(dto.dniNumero(), dto.dniLetra());
        //     actor.setDni(dni);
        // }

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
