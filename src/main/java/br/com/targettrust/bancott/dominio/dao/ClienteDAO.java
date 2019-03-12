package br.com.targettrust.bancott.dominio.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.targettrust.bancott.dominio.Agencia;
import br.com.targettrust.bancott.dominio.Cliente;

public interface ClienteDAO extends JpaRepository<Cliente, Long> {

}
