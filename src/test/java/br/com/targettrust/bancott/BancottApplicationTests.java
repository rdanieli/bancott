package br.com.targettrust.bancott;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.targettrust.bancott.dominio.Agencia;
import br.com.targettrust.bancott.dominio.dao.AgenciaDAO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BancottApplicationTests {

	@Autowired
	private AgenciaDAO agenciaDao; 
	
	@Test
	public void contextLoads() {
		
		List<Agencia> agencias = agenciaDao.findLikePeloNome("bela");
		
		for (Agencia agencia : agencias) {
			System.out.println(agencia.getNumero() + " - " + agencia.getNome());
		}
		
	}

}
