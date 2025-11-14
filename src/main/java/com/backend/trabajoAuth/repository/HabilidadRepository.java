package com.backend.trabajoAuth.repository;

import com.backend.trabajoAuth.models.Habilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HabilidadRepository extends JpaRepository<Habilidad, Long> {
    List<Habilidad> findByPersonaje_Id(Long personajeId);
}
