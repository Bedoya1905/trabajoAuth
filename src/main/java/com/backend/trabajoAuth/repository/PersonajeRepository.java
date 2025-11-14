package com.backend.trabajoAuth.repository;

import com.backend.trabajoAuth.models.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonajeRepository extends JpaRepository<Personaje, Long> {

    List<Personaje> findByUsuarioId(Long usuario);

}
