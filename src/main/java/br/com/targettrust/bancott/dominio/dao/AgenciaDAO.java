package br.com.targettrust.bancott.dominio.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.targettrust.bancott.dominio.Agencia;

@Repository
public interface AgenciaDAO extends CrudRepository<Agencia, Long>, AgenciaDAOCustom {

}
