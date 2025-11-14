package com.backend.trabajoAuth.controller;

import com.backend.trabajoAuth.models.Habilidad;
import com.backend.trabajoAuth.models.Personaje;
import com.backend.trabajoAuth.repository.HabilidadRepository;
import com.backend.trabajoAuth.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/personajes")
public class PersonajeController {

    @Autowired
    PersonajeRepository personajeRepository;
    @Autowired
    HabilidadRepository habilidadRepository;

    @GetMapping
    public ResponseEntity<List<Personaje>> getAllPersonajes() {
        try {
            List<Personaje> personajes = new ArrayList<Personaje>();
            
            personajeRepository.findAll().forEach(personajes::add);

            if (personajes.isEmpty()) 
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(personajes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*
    @GetMapping("/{id}")
    public ResponseEntity<Personaje> getById(@PathVariable("id") Long id) {
        try {
            Personaje personaje = personajeRepository.findById(id).orElse(null);
            List<Habilidad> habilidades = habilidadRepository.findByPersonaje_Id(id);

            if (personaje == null)
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(personaje, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getById(@PathVariable("id") Long id) {
        try {
            Optional<Personaje> personajeOpt = personajeRepository.findById(id);
            if (personajeOpt.isEmpty()) {
                return ResponseEntity.noContent().build();
            }

            Personaje personaje = personajeOpt.get();

            List<Habilidad> habilidades = habilidadRepository.findByPersonaje_Id(id);

            Map<String, Object> response = new HashMap<>();
            response.put("personaje", personaje);
            response.put("habilidades", habilidades);

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }


    @PostMapping
    public ResponseEntity<Personaje> postPersonaje(@RequestBody Personaje personaje) {
        try {
            personajeRepository.save(personaje);
            return new ResponseEntity<>(personaje, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/{id}/habilidades")
    public ResponseEntity<Habilidad> postHabilidad(@PathVariable int id, @RequestBody Habilidad habilidad) {
        try {
            Personaje personaje = personajeRepository.findById(Long.valueOf(id)).orElse(null);
            if (personaje == null) 
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

            habilidad.setPersonaje(personaje);
            habilidadRepository.save(habilidad);
            return new ResponseEntity<>(habilidad, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Personaje> putPersonaje(@PathVariable int id, @RequestBody Personaje personaje) {
        try {
            Personaje existingPersonaje = personajeRepository.findById(Long.valueOf(id)).orElse(null);
            if (existingPersonaje == null) 
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

            personaje.setId(existingPersonaje.getId());
            personajeRepository.save(personaje);

            return new ResponseEntity<>(personaje, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        try {
            Personaje existingPersonaje = personajeRepository.findById(Long.valueOf(id)).orElse(null);
            if (existingPersonaje == null) 
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

            habilidadRepository.deleteAll(habilidadRepository.findByPersonaje_Id(id));

            personajeRepository.deleteById(Long.valueOf(id));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{idPersonaje}/habilidades/{idHabilidad}")
    public ResponseEntity<Void> eliminarHabilidad(@PathVariable Long idPersonaje, @PathVariable Long idHabilidad) {

        Optional<Personaje> personajeOpt = personajeRepository.findById(idPersonaje);
        Optional<Habilidad> habilidadOpt = habilidadRepository.findById(idHabilidad);

        if (personajeOpt.isEmpty() || habilidadOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Habilidad habilidad = habilidadOpt.get();
        if (!habilidad.getPersonaje().getId().equals(idPersonaje)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build(); // No pertenece a ese personaje
        }

        habilidadRepository.deleteById(idHabilidad);
        return ResponseEntity.noContent().build();
    }
}
