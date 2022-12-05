package com.danielcelestino.minhasfinancas.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.danielcelestino.minhasfinancas.model.entity.Usuario;
import com.danielcelestino.minhasfinancas.model.repository.UsuarioRepository;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class UsuarioServiceTest {
	
	@Autowired
	UsuarioService service;
	
	@Autowired
	UsuarioRepository repository;
	
	@Test
	public void deveValidarEmail() {
		//cenario
		repository.deleteAll();
		
		//acao
		service.validarEmail("email@email.com");
		
	}
	
	@Test
	public void deveLancarErroAoValidarEmailQuandoExistirEmailCadastrado() {
		//Cenario
		repository.deleteAll();
		Usuario usuario = Usuario.builder().nome("usuario").email("usuario@email.com").build();
		repository.save(usuario);
		
		//acao
		service.validarEmail("email@email.com");
		
	}

}
