package com.danielcelestino.minhasfinancas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danielcelestino.minhasfinancas.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
