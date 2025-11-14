package com.backend.trabajoAuth.controller;

import com.backend.trabajoAuth.models.Personaje;
import com.backend.trabajoAuth.models.Usuario;
import com.backend.trabajoAuth.repository.PersonajeRepository;
import com.backend.trabajoAuth.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    PersonajeRepository personajeRepository;

    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        try {
            List<Usuario> usuarios = new ArrayList<Usuario>();

            usuarioRepository.findAll().forEach(usuarios::add);

            if (usuarios.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(usuarios, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/{id}/personajes")
    public ResponseEntity<List<Personaje>> getPersonajesByUser(@PathVariable("id") int id) {
        try {
            List<Personaje> personajes = new ArrayList<Personaje>();

            personajeRepository.findByUsuarioId(Long.valueOf(id)).forEach(personajes::add);

            if (personajes.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(personajes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
