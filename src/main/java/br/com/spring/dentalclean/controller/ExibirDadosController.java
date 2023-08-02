package br.com.spring.dentalclean.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.spring.dentalclean.dto.DentistaDTO;
import br.com.spring.dentalclean.dto.PacienteDTO;
import br.com.spring.dentalclean.dto.UsuarioDTO;
import br.com.spring.dentalclean.service.ListarService;

@RestController
@RequestMapping("/api/read")
public class ExibirDadosController {

	@Autowired
	ListarService listarService;
	
	
	 
	/**
	 * 
	 * Exibe todos os pacientes atualmente cadastrados no sistema;
	 * 
	 * @return Mensagem HTTP 200
	 */
	@GetMapping("/pacientes")
	public ResponseEntity<List<PacienteDTO>> listarPacientes() {
		List<PacienteDTO> list = listarService.listarTodosPacientes();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	
			 
	/**
	 * 
	 * Exibe todos os dentistas atualmente cadastrados no sistema;
	 * 
	 * @return Mensagem HTTP 200
	 */
	@GetMapping("/dentistas")
	public ResponseEntity<List<DentistaDTO>> listarDentistas() {
		List<DentistaDTO> list = listarService.listarTodosDentistas();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
		

	/**
	 * 
	 * Exibe todos os dentistas atualmente cadastrados no sistema;
	 * 
	 * @return Mensagem HTTP 200
	 */
	@GetMapping("/usuarios")
	public ResponseEntity<List<UsuarioDTO>> listarUsuarios() {
		List<UsuarioDTO> list = listarService.listarTodosUsuarios();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
		
	 
	
	/**
	 * Método busca de forma genérica pelo parametro da URL um ou mais registros que seja igual a
	 * String passada.
	 * 
	 * @param nome
	 * @return Mensagem HTTP
	 */
	@GetMapping("/listar/paciente/seach")
	public ResponseEntity<?> listarPacientePorNomeString(@RequestParam("nome") String nome) {
		
		List<PacienteDTO> pacienteDTO = listarService.listaPacientePorCadeiraDeCaracter(nome);
		
		if (!pacienteDTO.isEmpty()) {
			
			return new ResponseEntity<>(pacienteDTO, HttpStatus.OK);
			
		} else {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("Registro não encontrado. O paciente pode não estar cadastrado ou foi excluído!");
		}
		
	}
	
	
	
	
	/**
	 * Método busca de forma genérica pelo parametro da URL um ou mais registros que seja igual a
	 * String passada.
	 * 
	 * @param nome
	 * @return Mensagem HTTP
	 */
	@GetMapping("/listar/dentista/seach")
	public ResponseEntity<?> listarDentistaPorNomeString(@RequestParam("nome") String nome) {
		
		List<DentistaDTO> dentistaDTO = listarService.listaDentistaPorCadeiaDeCaracter(nome);
		
		if(!dentistaDTO.isEmpty()) {
			return new ResponseEntity<>(dentistaDTO, HttpStatus.OK);
		} else {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("Registro não encontrado. O paciente pode não estar cadastrado ou foi excluído!");
		}
			
	}
	
	
	
}
