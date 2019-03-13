package br.com.targettrust.bancott.dominio.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.targettrust.bancott.dominio.Conta;

public interface ContaDAO extends JpaRepository<Conta, Long> {

}
