// Integrantes
// URL de la pagina
// Dato autenticacion

package com.backend.trabajoAuth;

import com.backend.trabajoAuth.models.Habilidad;
import com.backend.trabajoAuth.models.Personaje;
import com.backend.trabajoAuth.models.Usuario;
import com.backend.trabajoAuth.repository.HabilidadRepository;
import com.backend.trabajoAuth.repository.PersonajeRepository;
import com.backend.trabajoAuth.repository.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TrabajoAuthApplication {

    private static final Logger log = LoggerFactory.getLogger(TrabajoAuthApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TrabajoAuthApplication.class, args);
	}

    /*
    @Bean
    public CommandLineRunner initData(
            UsuarioRepository usuarioRepository,
            PersonajeRepository personajeRepository,
            HabilidadRepository habilidadRepository
    ) {
        return args -> {

            // Usuarios

            Usuario user1 = new Usuario("John", "abcd");

            usuarioRepository.save(user1);
            usuarioRepository.save(new Usuario("Juan", "1234"));
            usuarioRepository.save(new Usuario("Pepe", "qwer"));

            log.info("Users found with findAll():");
            log.info("-------------------------------");
            usuarioRepository.findAll().forEach(user -> {
                log.info(user.toString());
            });
            log.info("");


            // Personajes
            Personaje personaje1 = new Personaje("Gagh-Ar", "Guerrero", "Un valiente luchador con gran fuerza física.", 80, 70, 60, usuarioRepository.findById(1L).orElse(user1));
            Personaje personaje2 = new Personaje("Elyra", "Mago", "Hechicera con gran dominio de la energía mágica.", 65, 40, 90, usuarioRepository.findById(1L).orElse(user1));
            Personaje personaje3 = new Personaje("Santiago-Son", "Samurai", "El golden boy que siempre salva el día", 75, 65, 70, usuarioRepository.findById(1L).orElse(user1));
            Personaje personaje4 = new Personaje("NikoNi", "Mafioso", "Un bueno para nada que se quiere parecer a Kiryu kazuma", 50, 105, 80, usuarioRepository.findById(1L).orElse(user1));
            Personaje personaje5 = new Personaje("Lautiti", "Mago", "Conocido por su increíble pelo rubio y también conocido por el nombre: Ti", 70, 20, 100, usuarioRepository.findById(1L).orElse(user1));
            personajeRepository.save(personaje1);
            personajeRepository.save(personaje2);
            personajeRepository.save(personaje3);
            personajeRepository.save(personaje4);
            personajeRepository.save(personaje5);

            log.info("Personajes found with findAll():");
            log.info("-------------------------------");
            personajeRepository.findAll().forEach(personaje -> {
                log.info(personaje.toString());
            });
            log.info("");


            // Habilidades
            Habilidad habilidad1 = new Habilidad("Espadazo", "Un ataque poderoso con la espada.", 10, 0, -5, personajeRepository.findById(1L).orElse(personaje1));
            Habilidad habilidad2 = new Habilidad("Escudo de Hierro", "Aumenta la defensa del usuario.", 0, 15, -3, personajeRepository.findById(1L).orElse(personaje1));
            Habilidad habilidad3 = new Habilidad("Bendición Mística", "Aumenta el sp del usuario.", 0, 0, 20, personajeRepository.findById(1L).orElse(personaje1));
            Habilidad habilidad4 = new Habilidad("Furia del Dragón", "Un ataque devastador que sacrifica defensa por poder.", 20, -10, -10, personajeRepository.findById(1L).orElse(personaje1));
            Habilidad habilidad5 = new Habilidad("Bola de huevo", "Tira una bola con mucho huevo.", 12, -1, -7, personajeRepository.findById(1L).orElse(personaje1));
            habilidadRepository.save(habilidad1);
            habilidadRepository.save(habilidad2);
            habilidadRepository.save(habilidad3);
            habilidadRepository.save(habilidad4);
            habilidadRepository.save(habilidad5);

            log.info("Habilidades found with findAll():");
            log.info("-------------------------------");
            habilidadRepository.findAll().forEach(habilidad -> {
                log.info(habilidad.toString());
            });
            log.info("");

        };
    }*/


}
