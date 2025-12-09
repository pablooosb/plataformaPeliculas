package edu.pabloSalgado.practica.plataformaPeliculas.controller;

import java.util.List;
import edu.pabloSalgado.practica.plataformaPeliculas.service.interfaces.IDirectorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pabloSalgado.practica.plataformaPeliculas.model.Director;
import edu.pabloSalgado.practica.plataformaPeliculas.model.dto.DirectorDTO;
import edu.pabloSalgado.practica.plataformaPeliculas.model.mapper.DirectorMapper;

@RestController
@RequestMapping("/directores")
public class DirectorController {
    @Autowired
    private IDirectorService directorService;
    @Autowired
    private DirectorMapper directorMapper;

    @PostMapping("/add")
    public DirectorDTO addDirector(@RequestBody DirectorDTO directorDTO){
        Director director = directorService.addDirector(directorDTO);
        return directorMapper.toDto(director);
    }

    @GetMapping
    public List<Director> listarDirectores(){
        return directorService.showAllDirectors();
    }

    @GetMapping("/{id}")
    public DirectorDTO directorPorId(@PathVariable("id") Long id){
        return directorMapper.toDto(directorService.showDirectorById(id));
    }

    @PostMapping("/update")
    public DirectorDTO updateDirector(@RequestBody DirectorDTO directorDTO){
        Director director = directorMapper.toEntity(directorDTO);
        Director updated = directorService.updateDirector(director);
        return directorMapper.toDto(updated);    
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDirector(@PathVariable("id") Long id){
        try {
            directorService.deleteDirectorById(id);
        } catch (Exception e){
            System.err.println("Error al eliminar el director con id " + id + ": " + e.getMessage());
            throw e;
        }
    }

    // Endpoint para obtener directores mayores a 70 años
    @GetMapping("/mayoresA70")
    public List<Director> findDirectoresMayoresA70(){
        return directorService.findDirectoresMayoresA70();
    }
}
