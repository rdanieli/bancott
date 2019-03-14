package br.com.targettrust.bancott.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@GetMapping(path = "/clientes/{id}")
	public Optional<Cliente> obtemClientes(@PathVariable Long id) {
		return clienteDao.findById(id);
	}
		
	@PostMapping(path = "/clientes")
	public ResponseEntity criarCliente(@Valid @RequestBody Cliente cliente) {
		Cliente clienteSalvo = clienteDao.save(cliente);
		
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(clienteSalvo.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	
}
