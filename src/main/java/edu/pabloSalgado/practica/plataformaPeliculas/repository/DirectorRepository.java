package edu.pabloSalgado.practica.plataformaPeliculas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.pabloSalgado.practica.plataformaPeliculas.model.Director;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Long>{
    // buscar los directores que tienen mas de 70 años
    @Query("SELECT d FROM Director d WHERE (YEAR(CURRENT_DATE) - d.fecha_nacimiento.anho) > 70")
    List<Director> findDirectoresMayoresA70();
}
