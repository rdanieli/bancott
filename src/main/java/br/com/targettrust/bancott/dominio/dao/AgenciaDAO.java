package br.com.targettrust.bancott.dominio.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.targettrust.bancott.dominio.Agencia;

public interface AgenciaDAO extends JpaRepository<Agencia, Long>, AgenciaDAOCustom {

}
