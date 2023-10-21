package br.com.spring.dentalclean.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.spring.dentalclean.dto.DentistaDTO;
import br.com.spring.dentalclean.dto.PacienteDTO;
import br.com.spring.dentalclean.dto.UsuarioDTO;
import br.com.spring.dentalclean.service.UpdateService;

@RestController
@CrossOrigin(origins = "*")
public class UpdateController {

	@Autowired
	UpdateService updateService;
	
	 
	/**
	 * Atualiza um registro localizando por id e que o paciente estaja cadastrado no sistema.
	 * @param id
	 * @param pacienteDTO
	 * @return Mensagem HTTP 200 com os dados atualizados
	 */
	@PutMapping("/atualizar/cadastro/paciente")
	public ResponseEntity<PacienteDTO> putDataPaciente(@RequestParam Long id, @RequestBody PacienteDTO pacienteDTOHttp) {
		
		PacienteDTO updatePaciente = updateService.updatePaciente(id, pacienteDTOHttp);
		
		return ResponseEntity.ok(updatePaciente);
 	
	}
	
	
	/**
	 * Atualiza um registro localizando por id e que o paciente estaja cadastrado no sistema.
	 * @param id
	 * @param pacienteDTO
	 * @return Mensagem HTTP 200 com os dados atualizados
	 */
	@PutMapping("/atualizar/cadastro/dentista")
	public ResponseEntity<DentistaDTO> putDataDentista(@RequestParam Integer cro, @RequestBody DentistaDTO dentistaDTOHttp) {
		
		DentistaDTO updateDentista = updateService.updateDentista(cro, dentistaDTOHttp);
		
		return ResponseEntity.ok(updateDentista);
	}
	
	
	
 
	/**
	 * Atualiza um registro localizando por id e que o usuário estaja cadastrado no sistema.
	 * @param id
	 * @param pacienteDTO
	 * @return Mensagem HTTP 200 com os dados atualizados
	 */
	@PutMapping("/atualizar/cadastro/usuario")
	public ResponseEntity<UsuarioDTO> putDataUsuario(@RequestParam Long id, @RequestBody UsuarioDTO usuarioDTOHttp) {
		
		UsuarioDTO updateUsuario = updateService.updateUsuario(id, usuarioDTOHttp);
			 
		return ResponseEntity.ok(updateUsuario);		
	}
}
