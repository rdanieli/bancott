package br.com.targettrust.bancott.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.targettrust.bancott.dominio.Agencia;
import br.com.targettrust.bancott.dominio.AgenciaDTO;
import br.com.targettrust.bancott.dominio.dao.AgenciaDAO;

@RestController
public class AgenciaResource {

	@Autowired
	private AgenciaDAO agenciaDao;
	
	@GetMapping(path = "/agencias")
	public List<AgenciaDTO> obtemClientes() {
		
		List<AgenciaDTO> agenciaDTOs = new ArrayList<>();
		
		for (Agencia agencia : agenciaDao.findAll()) {
			AgenciaDTO dto = new AgenciaDTO(agencia.getNome(), agencia.getNumero());
			
			agenciaDTOs.add(dto);
		}
		
		return agenciaDTOs;
	}
	
	@GetMapping(path = "/agencias/{id}")
	public AgenciaDTO obtemAgencias(@PathVariable Long id) {
		
		Agencia agencia = agenciaDao.findById(id).get();
		
		return new AgenciaDTO(agencia.getNome(), agencia.getNumero());
		
	}
		
	@PostMapping(path = "/agencias")
	public ResponseEntity criarAgencia(@RequestBody Agencia agencia) {
		Agencia agenciaSalva = agenciaDao.save(agencia);
		
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(agenciaSalva.getNumero()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	
}
