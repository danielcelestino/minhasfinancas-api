package com.danielcelestino.minhasfinancas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.danielcelestino.minhasfinancas.model.entity.Usuario;
import com.danielcelestino.minhasfinancas.model.repository.UsuarioRepository;

@SpringBootApplication
public class MinhasfinancasApplication {
	
	@Bean
	public CommandLineRunner commandLineRunner(@Autowired UsuarioRepository contatoRepository) {
		return args -> {
			Usuario u = new Usuario();
			u.setNome("Fulano");
			u.setEmail("fulano@gmail.com");
			u.setSenha("123");
			contatoRepository.save(u);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(MinhasfinancasApplication.class, args);
	}

}
