package br.com.targettrust.bancott.dominio.dao;

import java.util.List;

import br.com.targettrust.bancott.dominio.Agencia;

public interface AgenciaDAOCustom {

	List<Agencia> findLikePeloNome(String stringBusca);
	
}
