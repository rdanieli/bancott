package br.com.targettrust.bancott.dominio.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import br.com.targettrust.bancott.dominio.Agencia;

public class AgenciaDAOImpl implements AgenciaDAOCustom {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Agencia> findLikePeloNome(String stringBusca) {
		
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("SELECT a FROM Agencia a join a.contas ");
		stringBuilder.append("where upper(a.nome) like ?1");
		
		Query query = entityManager.createQuery(stringBuilder.toString());
		query.setParameter(1, "%"+stringBusca.toUpperCase()+"%");
		
		
		return query.getResultList();
	}

}
