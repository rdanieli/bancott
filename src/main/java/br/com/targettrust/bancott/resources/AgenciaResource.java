package br.com.targettrust.bancott.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
import br.com.targettrust.bancott.dominio.dao.AgenciaDAO;

@RestController
public class AgenciaResource {

	@Autowired
	private AgenciaDAO agenciaDao;
	
	@RequestMapping(path = "/agencias", method= RequestMethod.GET)
	public List<AgenciaDTO> obtemAgencias() {
		
		List<AgenciaDTO> agenciaDTOs = new ArrayList<>();
		
		
		List<Agencia> a = agenciaDao.findAll()
				  .stream()
				  .filter(p -> p.getCnpj().equals("10.562.198/0001-50"))
				  .collect(Collectors.toList());
		
		
		for (Agencia agencia : agenciaDao.findAll()) {
			if(agencia.getCnpj().equals("10.562.198/0001-50")) {
				AgenciaDTO dto = new AgenciaDTO(agencia.getNome(), agencia.getNumero());
				
				agenciaDTOs.add(dto);
			}
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
