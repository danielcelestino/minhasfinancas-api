package com.danielcelestino.minhasfinancas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danielcelestino.minhasfinancas.model.entity.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{

}
