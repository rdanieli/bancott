package br.com.targettrust.bancott.dominio.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.targettrust.bancott.dominio.Agencia;

@Repository
public class AgenciaDAOImpl implements AgenciaDAOCustom {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Agencia> findLikePeloNome(String stringBusca) {
		
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select a.* ");
		stringBuilder.append("from agencias a ");
		stringBuilder.append("where upper(a.nome) like ?");
		
		Query query = entityManager.createNativeQuery(stringBuilder.toString(), Agencia.class);
		query.setParameter(1, "%"+stringBusca.toUpperCase()+"%");
		
		return query.getResultList();
	}

}
