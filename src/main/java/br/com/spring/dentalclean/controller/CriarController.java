package br.com.spring.dentalclean.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.spring.dentalclean.dto.DentistaDTO;
import br.com.spring.dentalclean.dto.PacienteDTO;
import br.com.spring.dentalclean.dto.UsuarioDTO;
import br.com.spring.dentalclean.service.CriarService;

@RestController
@RequestMapping("/api/cadastro")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CriarController {	
	
	@Autowired
	private CriarService criarService; 
	
	
	/**
	 * Primeira funcionalidade do sistema - Cria um cadastro novo de um pacinte no sistema.
	 * @param pacienteDTO
	 * @return Mensagem HTTP
	 */
	@PostMapping("/paciente")
	@CrossOrigin(methods = RequestMethod.POST)
	public ResponseEntity<PacienteDTO> cadastroDePaciente(@RequestBody PacienteDTO pacienteDTO) {	
		criarService.cadastrarPaciente(pacienteDTO);
		return ResponseEntity.ok().build();
	}
	
	
	
	 
	/**
	 * Primeira funcionalidade do sistema - Cria um cadastro novo de um dentista no sistema.
	 * @param cadastroDentistaDTO
	 * @return Mensagem HTTP
	 */
	@PostMapping(value = "/dentista")
	@CrossOrigin(methods = RequestMethod.POST)
	public ResponseEntity<DentistaDTO> cadastroDeDentista(@RequestBody DentistaDTO cadastroDentistaDTO) {
		
		criarService.cadastrarDentista(cadastroDentistaDTO);		
		return ResponseEntity.ok().build();
	}
	
	
	 
	/**
	 * Primeira funcionalidade do sistema - Cria um cadastro novo de um usuário do sistema.
	 * @param usuarioDTO
	 * @return Mensagem HTTP
	 */
	@PostMapping(value = "usuario")
	@CrossOrigin(methods = RequestMethod.POST)
	public ResponseEntity<UsuarioDTO> cadastroUsuario(@RequestBody UsuarioDTO usuarioDTO) {
		
		criarService.cadastrarUsuario(usuarioDTO);		
		return ResponseEntity.ok().build();
	}
	
	
}
