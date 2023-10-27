package br.com.spring.dentalclean.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.spring.dentalclean.dto.DentistaDTO;
import br.com.spring.dentalclean.dto.PacienteDTO;
import br.com.spring.dentalclean.dto.UsuarioDTO;
import br.com.spring.dentalclean.service.UpdateService;

@RestController
@RequestMapping("atualizar")
@CrossOrigin(origins = "*", methods = RequestMethod.PUT, allowCredentials = "true")
public class UpdateController {

	@Autowired
	UpdateService updateService;
	
	 
	/**
	 * Atualiza um registro localizando por id e que o paciente estaja cadastrado no sistema.
	 * @param id
	 * @param pacienteDTO
	 * @return Mensagem HTTP 200 com os dados atualizados
	 */
	@PutMapping("/cadastro/paciente/{id}")
	@CrossOrigin(methods = RequestMethod.PUT)
	public ResponseEntity<PacienteDTO> putDataPaciente(@PathVariable("id") Long id, @RequestBody PacienteDTO pacienteDTOHttp) {
				
		PacienteDTO updatePaciente = updateService.updatePaciente(id, pacienteDTOHttp);
		
		return ResponseEntity.ok(updatePaciente);
 	
	}
	
	
	/**
	 * Atualiza um registro localizando por id e que o paciente estaja cadastrado no sistema.
	 * @param id
	 * @param pacienteDTO
	 * @return Mensagem HTTP 200 com os dados atualizados
	 */
	@PutMapping("/cadastro/dentista/{id}")
	@CrossOrigin(origins = "http://localhost:3000/", methods = RequestMethod.PUT)
	public ResponseEntity<DentistaDTO> putDataDentista(@PathVariable(name = "id") Long id, @RequestBody DentistaDTO dentistaDTOHttp) {
		
		//Long id = Long.valueOf(idString);
		
		DentistaDTO updateDentista = updateService.updateDentista(id, dentistaDTOHttp);
		
		return ResponseEntity.ok(updateDentista);
	}
	
	
	
 
	/**
	 * Atualiza um registro localizando por id e que o usuário estaja cadastrado no sistema.
	 * @param id
	 * @param pacienteDTO
	 * @return Mensagem HTTP 200 com os dados atualizados
	 */
	@PutMapping("/cadastro/usuario/{id}")
	@CrossOrigin(methods = RequestMethod.PUT)
	public ResponseEntity<UsuarioDTO> putDataUsuario(@PathVariable(name = "id") Long id, @RequestBody UsuarioDTO usuarioDTOHttp) {
		
		UsuarioDTO updateUsuario = updateService.updateUsuario(id, usuarioDTOHttp);
			 
		return ResponseEntity.ok(updateUsuario);		
	}
}
