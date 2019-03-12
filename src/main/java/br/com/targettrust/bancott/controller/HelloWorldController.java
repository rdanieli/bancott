package br.com.targettrust.bancott.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.targettrust.bancott.dominio.HelloWorld;

@RestController
public class HelloWorldController {

	@GetMapping(path="/denovo")
	public String meuHelloWorld() {
		return "Olá Mundo";
	}
		
	
	@GetMapping(path= {"/denovo-obj", "/denovo-obj/{var}"})
	public HelloWorld meuHelloWorldObj(@RequestParam("p") String p, 
									   @PathVariable(required=false) String var) {
		HelloWorld hw = new HelloWorld();
		hw.setMensagem(p);
		hw.setValor(500.0);
		return hw;
	}
	
	
}
