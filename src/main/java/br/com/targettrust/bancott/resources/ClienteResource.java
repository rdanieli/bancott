package br.com.targettrust.bancott.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.targettrust.bancott.dominio.Cliente;
import br.com.targettrust.bancott.dominio.dao.ClienteDAO;

@RestController
public class ClienteResource {

	@Autowired
	private ClienteDAO clienteDao;
	
	@GetMapping(path = "/clientes")
	public List<Cliente> obtemClientes() {
		return clienteDao.findAll();
	}
	
	
}
