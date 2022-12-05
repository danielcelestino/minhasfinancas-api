package com.danielcelestino.minhasfinancas.model.repository;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.danielcelestino.minhasfinancas.model.entity.Usuario;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class UsuarioRepositoryTest{
	
	@Autowired
	UsuarioRepository repository;
	
	@Autowired
	TestEntityManager entityManager;

	@Test
	public void deveVerificarAExistenciaDeUmEmail() {
		
		//Cenario
		Usuario usuario = criarUsuario();
		entityManager.persist(usuario);
		
		//ação/execução
		boolean result = repository.existsByEmail("usuario@email.com");
		
		//verificação
		Assertions.assertThat(result).isTrue();
	}
	
	@Test
	public void deveRetornarFalsoQuandoNaoHouverUsuarioCadastradoComEmail() {
		
		//Cenario
//		repository.deleteAll(); não precisa mais por conta do @DataJpaTest
		
		//ação/execução
		boolean result = repository.existsByEmail("usuario@email.com");
		
		//verificação
		Assertions.assertThat(result).isFalse();
	}
	
	@Test
	public void devePersistirUsuarioNaBaseDeDados() {
		//Cenario
		Usuario usuario = criarUsuario();
		
		//ação/execução
		Usuario usuarioSalvo = repository.save(usuario);
		
		//verificação
		Assertions.assertThat(usuarioSalvo.getId()).isNotNull();
	}
	
	@Test
	public void deveBuscarUmUsuarioPorEmail() {
		//Cenario
		Usuario usuario = criarUsuario();
		entityManager.persist(usuario);
		
		//ação/execução
		Optional<Usuario> usuarioRecuperado = repository.findByEmail("usuario@email.com");
		
		//verificação
		Assertions.assertThat(usuarioRecuperado.isPresent()).isTrue();
	}
	
	@Test
	public void deveRetornarVazioAoBuscarUsuarioPorEmailQuandoNaoExisteNaBase() {
		//Cenario
		
		//ação/execução
		Optional<Usuario> usuarioRecuperado = repository.findByEmail("usuario@email.com");
		
		//verificação
		Assertions.assertThat(usuarioRecuperado.isPresent()).isFalse();
	}
	
	
	public static Usuario criarUsuario() {
		return Usuario.builder()
				.nome("usuario")
				.senha("123")
				.email("usuario@email.com")
				.build();
	}

}
