package edu.pabloSalgado.practica.plataformaPeliculas.service.interfaces;

import java.util.List;

import edu.pabloSalgado.practica.plataformaPeliculas.model.Director;
import edu.pabloSalgado.practica.plataformaPeliculas.model.dto.DirectorDTO;

public interface IDirectorService {
    // añadir director
    Director addDirector(DirectorDTO dto);
    // obtener todos los directores
    List<Director> showAllDirectors();
    // obtener director por id
    Director showDirectorById(Long id);
    // actualizar directores por dni
    Director updateDirector(Director director);
    // eliminar director por id
    void deleteDirectorById(Long id);
    // buscar directores mayores a 70 años
    List<Director> findDirectoresMayoresA70();
}
