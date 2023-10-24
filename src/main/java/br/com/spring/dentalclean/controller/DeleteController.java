package br.com.spring.dentalclean.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.spring.dentalclean.dto.DentistaDTO;
import br.com.spring.dentalclean.dto.PacienteDTO;
import br.com.spring.dentalclean.dto.UsuarioDTO;
import br.com.spring.dentalclean.service.DeleteService;

@RestController
<<<<<<< HEAD
@RequestMapping("")
@CrossOrigin(origins = "*", allowedHeaders = "*")
=======
@CrossOrigin(origins = "*")
>>>>>>> ed8e8a12347cb490bdcb80451b99a11885561a9e
public class DeleteController {
	
	
	@Autowired
	private DeleteService deleteService;

		
	/**
	 * Controller para delete falso. Recebe uma lista de id para um ou mais ids
	 * que serão deletados. Invoca o método para realizar a tarefa de delete falso 
	 * na base de dados. 
	 * 
	 * Invocado o método para validar se o paciente realmente foi deletado e, o 
	 * retorno http depende dessa validação.
	 * 
	 * @param id
	 * @return Mensagem HTTP
	 */
	@DeleteMapping("/api/delete/paciente")
	public ResponseEntity<PacienteDTO> deletePacienteForIdFalso(@RequestParam("ids") List<Long> id) {
		
		deleteService.deletePacientePorIdFalse(id);
		
		Boolean pacienteDeletado = deleteService.validadorPacienteDeletadoFalse(id);
		
		if (pacienteDeletado) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
				
	}
	
	
	/**
	 * Método para deletar na api de forma autência, os dados serão deletados de fato da 
	 * base de dados. Realizando uma chamada para a camada service e feito o delete.
	 * 
	 * @param id
	 * @return Mensagem HTTP
	 */
	@DeleteMapping("/api/delete_aut/paciente")
	public ResponseEntity<PacienteDTO> deleteAutenticoIDPaciente(@RequestParam("ids") List<Long> id) {
		
		Boolean deletePacienteAutenticoPorId = deleteService.deletePacienteAutenticoPorId(id);
		
		if (deletePacienteAutenticoPorId) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
	}
	
	
 
	/**
	 * Controller para delete falso. Recebe uma lista de id para um ou mais ids
	 * que serão deletados. Invoca o método para realizar a tarefa de delete falso 
	 * na base de dados. 
	 * 
	 * Invocado o método para validar se o dentista realmente foi deletado e, o 
	 * retorno http depende dessa validação.
	 * 
	 * @param cro
	 * @return Mensagem HTTP
	 */
	
	@DeleteMapping("/api/delete/dentista")
<<<<<<< HEAD
	public ResponseEntity<DentistaDTO> deleteDentistaForIdFalso(@RequestParam("cros") List<Integer> cro) {
=======
	public ResponseEntity<DentistaDTO> deleteDentistaForIdFalso(@RequestParam("cro") Integer cro) {
>>>>>>> ed8e8a12347cb490bdcb80451b99a11885561a9e
		
		deleteService.deleteDentistaPorCroFalse(cro);
		
		Boolean dentistaDeletado = deleteService.validadorDentistaDeletadoFalse(cro);
		
		if (dentistaDeletado) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
	}

	
	
	/**
	 * Método para deletar na api de forma autência, os dados serão deletados de fato da 
	 * base de dados. Realizando uma chamada para a camada service e feito o delete.
	 * 
	 * @param id
	 * @return Mensagem HTTP
	 */
	@DeleteMapping("/api/delete_aut/dentista")
	public ResponseEntity<DentistaDTO> deleteAutenticoIdDentista(@RequestParam("cros") List<Integer> cros) {
		
		Boolean deleteDentistaAutenticoPorId = deleteService.deleteDentistaAutenticoPorId(cros);
		
		if (deleteDentistaAutenticoPorId) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
	}
	
	
	
	
 
	
	/**
	 * Controller para delete falso. Recebe uma lista de id para um ou mais ids
	 * que serão deletados. Invoca o método para realizar a tarefa de delete falso 
	 * na base de dados. 
	 * 
	 * Invocado o método para validar se o usuário realmente foi deletado e, o 
	 * retorno http depende dessa validação.
	 * 
	 * @param id
	 * @return Mensagem HTTP
	 */
	@DeleteMapping("/api/delete/usuario")
	public ResponseEntity<UsuarioDTO> deleteUserFalse(@RequestParam("id") Long id) {
		
		deleteService.deleteUsuarioPorIdFalse(id);
		
		Boolean deleteFalsoValidadorUsuario = deleteService.validadorUsuarioDeletadoFalse(id) ;
			
		if (deleteFalsoValidadorUsuario) {
			return ResponseEntity.ok().build();
		} else { 
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
	}
	
	

	
	
	
}
