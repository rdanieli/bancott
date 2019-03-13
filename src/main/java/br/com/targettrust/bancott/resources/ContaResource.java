package br.com.targettrust.bancott.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.targettrust.bancott.dominio.Agencia;
import br.com.targettrust.bancott.dominio.AgenciaDTO;
import br.com.targettrust.bancott.dominio.Cliente;
import br.com.targettrust.bancott.dominio.Conta;
import br.com.targettrust.bancott.dominio.ContaDTO;
import br.com.targettrust.bancott.dominio.dao.AgenciaDAO;
import br.com.targettrust.bancott.dominio.dao.ClienteDAO;
import br.com.targettrust.bancott.dominio.dao.ContaDAO;

@RestController
public class ContaResource {

	@Autowired
	private AgenciaDAO agenciaDao;

	@Autowired
	private ContaDAO contaDao;
	
	@Autowired
	private ClienteDAO clienteDao;
	
	
	@GetMapping(path="/contas/{id}")
	public ContaDTO buscaConta(@PathVariable Long id) {
		
		Conta contaSalva = contaDao.findById(id).get();
		
		ContaDTO contaDTO = new ContaDTO();
		
		contaDTO.setNomeCliente(contaSalva.getCliente().getNome());
		contaDTO.setNumeroAgencia(contaSalva.getAgencia().getNumero().toString());
		contaDTO.setNumeroConta(contaSalva.getNumero().toString());
		
		contaDTO.setSaldo(contaSalva.getSaldo());
		
		
		return contaDTO;
	}
	
	@PostMapping(path = "/contas/{agenciaNumero}/{idCliente}")
	public ResponseEntity criarConta(@RequestBody ContaDTO contaDTO, 
									 @PathVariable Long agenciaNumero, 
									 @PathVariable Long idCliente ) {
		
		Conta novaConta = new Conta();
		
		if(contaDTO != null) {
			novaConta.setSaldo(contaDTO.getSaldo());
		}
		
		Agencia agencia = agenciaDao.findById(agenciaNumero).get();
		
		novaConta.setAgencia(agencia);
		
		Cliente cliente = clienteDao.findById(idCliente).get();
		
		novaConta.setCliente(cliente);
		
		Conta contaSalva = contaDao.save(novaConta);
		
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(contaSalva.getNumero()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	
}
