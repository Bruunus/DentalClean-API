package br.com.spring.dentalclean.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.spring.dentalclean.dto.ItemCadastroDTOTeste;
import br.com.spring.dentalclean.service.CadastroDTO;

@RestController
@RequestMapping("/test")
public class TestConnectionController {
	
	@Autowired
	private CadastroDTO cadastroDTO;

	@GetMapping("/testConn")
	public String testConnection() {
		
		return "Well done !!!";
	}
	
	
	@RequestMapping("/data")
	public String receiveData(@RequestBody String text) {
		System.out.println("Texto enviado do postman: "+text);
		return "You typed "+text;
	}
	
	
	
	@RequestMapping("/dataCollection")
	public List<ItemCadastroDTOTeste> receiveCollectionData(@RequestBody CadastroDTO cadastroDTO) {
		
		List<ItemCadastroDTOTeste> cadastro = cadastroDTO.getCadastro();
		
		cadastro.forEach(i -> {
			System.out.println(i);
		});
		
	    return cadastro;
	}
	
	
	
}
