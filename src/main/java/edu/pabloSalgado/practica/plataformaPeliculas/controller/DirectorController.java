package edu.pabloSalgado.practica.plataformaPeliculas.controller;

import java.util.List;
import edu.pabloSalgado.practica.plataformaPeliculas.service.interfaces.IDirectorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pabloSalgado.practica.plataformaPeliculas.model.Director;

@RestController
@RequestMapping("/directores")
public class DirectorController {
    @Autowired
    private IDirectorService directorService;

    // buscar directores mayores a 70 años
    @GetMapping("/mayoresA70")
    public List<Director> findDirectoresMayoresA70(){
        return directorService.findDirectoresMayoresA70();
    }
}
