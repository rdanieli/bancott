package br.com.targettrust.bancott;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.targettrust.bancott.dominio.Agencia;
import br.com.targettrust.bancott.dominio.Cliente;
import br.com.targettrust.bancott.dominio.Conta;
import br.com.targettrust.bancott.dominio.dao.AgenciaDAO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BancottApplicationTests {

	@Autowired
	private AgenciaDAO agenciaDao; 
	
	@Test
	public void contextLoads() {
		Agencia ag1 = agenciaDao.findById(132L).get();
		
		Cliente cliente = new Cliente();
		cliente.setNome("Instrutor");
		
		Conta c1 = new Conta();
		c1.setCliente(cliente);
		c1.setAgencia(ag1);
		c1.setSaldo(1350d);
		
		Cliente cliente2 = new Cliente();
		cliente2.setNome("Instrutor2");
		
		Conta c2 = new Conta();
		c2.setCliente(cliente2);
		c2.setAgencia(ag1);
		c2.setSaldo(120d);
		
			
		List<Conta> contas = new ArrayList<>();
		contas.add(c1);
		contas.add(c2);
		
		ag1.setContas(contas);
		
		agenciaDao.save(ag1);
	}

}
