package br.com.spring.dentalclean.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.spring.dentalclean.dto.DentistaDTO;
import br.com.spring.dentalclean.dto.PacienteDTO;
import br.com.spring.dentalclean.dto.UsuarioDTO;
import br.com.spring.dentalclean.model.Dentista;
import br.com.spring.dentalclean.model.Paciente;
import br.com.spring.dentalclean.model.Usuario;
import br.com.spring.dentalclean.repository.DentistaRepository;
import br.com.spring.dentalclean.repository.PacienteRepository;
import br.com.spring.dentalclean.repository.UsuarioRepository;

@Service
public class UpdateService {

	@Autowired
	PacienteRepository pacienteRepository;
	
	@Autowired
	DentistaRepository detistaRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	PacienteDTO pacienteDTO;
	
	DentistaDTO dentistaDTO;
	
	UsuarioDTO usuarioDTO;

	 
	
	
	/**
	 * Método recebe em parâmetro um id para localizar o paciente e os dados para serem atualizados no
	 * corpo da requisição como em formato de um objeto PacientDTO.
	 * 
	 * Realizado instancia de um PacienteDTO para autenticar os dados e seus tipos, realizado uma busca
	 * pelo paciente pelo id, caso id não encontrado é lançado um Exception do tipo ResponseStatusException
	 * para retornar uma mensagem HTTP para o navegador no código 404 e a mensagem de orientação.
	 * 
	 * Realiza a atualização desse paciente encontrado como os novos dados atualizados da request e salva-os
	 * na base de dados e por fim realiza a transformação dos dados salvos em um objeto DTO para ser retornado
	 * para o controler.
	 * 
	 * @param id
	 * @param pacienteDTOHttp
	 * @return Objeto DTO do tipo PacienteDTO
	 */
	public PacienteDTO updatePaciente(Long id, PacienteDTO pacienteDTOHttp) {
		
		pacienteDTO = new PacienteDTO();		 		
		
		Paciente buscaPaciente = pacienteRepository.findByIdAndNaoDeletado(id, true)
		        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro de dentista não encontrado. Pode ser alterado ou deletado"));

		
		buscaPaciente.setNomeCompleto(pacienteDTOHttp.getNomeCompleto());
		buscaPaciente.setDataNascimento(pacienteDTOHttp.getDataNascimento());
		buscaPaciente.setGenero(pacienteDTOHttp.getGenero());
		buscaPaciente.setEmail(pacienteDTOHttp.getEmail());
		buscaPaciente.setConvenio(pacienteDTOHttp.getConvenio());
		
		
//		Integer numCarteirinha = pacienteDTO.conversorInteger(pacienteDTOHttp.getNumeroCarteirinha());
//		buscaPaciente.setNumeroCarteirinha(numCarteirinha);
		buscaPaciente.setNumeroCarteirinha(pacienteDTOHttp.getNumeroCarteirinha());
		
		
		buscaPaciente.setRua(pacienteDTOHttp.getRua());
		
		
		Integer numero = pacienteDTO.conversorInteger(pacienteDTOHttp.getNumero());
		buscaPaciente.setNumero(numero);
		
		
		buscaPaciente.setBairro(pacienteDTOHttp.getBairro());
		buscaPaciente.setCidade(pacienteDTOHttp.getCidade());
		buscaPaciente.setEstado(pacienteDTOHttp.getEstado());
		
		
		Paciente dadosAtualizados = pacienteRepository.save(buscaPaciente);		
		
		
		pacienteDTO.setNomeCompleto(dadosAtualizados.getNomeCompleto());
		pacienteDTO.setDataNascimento(dadosAtualizados.getDataNascimento());
		pacienteDTO.setGenero(dadosAtualizados.getGenero());
		pacienteDTO.setEmail(dadosAtualizados.getEmail());
		pacienteDTO.setConvenio(dadosAtualizados.getConvenio());
		
		
//		Integer numeroCarteirinhaInteger = dadosAtualizados.getNumeroCarteirinha();		
//		String numeroCarteirinhaString = pacienteDTO.conversorString(numeroCarteirinhaInteger);
//		pacienteDTO.setNumeroCarteirinha(numeroCarteirinhaString);		
		pacienteDTO.setNumeroCarteirinha(dadosAtualizados.getNumeroCarteirinha());
		
		
		pacienteDTO.setRua(dadosAtualizados.getRua());		
		
		Integer numeroInteger = dadosAtualizados.getNumero();		
		String numeroString = pacienteDTO.conversorString(numeroInteger);		
		pacienteDTO.setNumero(numeroString);
		
		pacienteDTO.setBairro(dadosAtualizados.getBairro());
		pacienteDTO.setCidade(dadosAtualizados.getCidade());
		pacienteDTO.setEstado(dadosAtualizados.getEstado());		
		
		return pacienteDTO;
	}



	/**
	 * Método recebe em parâmetro um id para localizar o dentista e os dados para serem atualizados no
	 * corpo da requisição como em formato de um objeto DentistaDTO.
	 * 
	 * Realizado instancia de um DentistaDTO para autenticar os dados e seus tipos, realizado uma busca
	 * pelo paciente pelo id, caso id não encontrado é lançado um Exception do tipo ResponseStatusException
	 * para retornar uma mensagem HTTP para o navegador no código 404 e a mensagem de orientação.
	 * 
	 * Realiza a atualização desse dentista encontrado como os novos dados atualizados da request e salva-os
	 * na base de dados e por fim realiza a transformação dos dados salvos em um objeto DTO para ser retornado
	 * para o controler.
	 * 
	 * @param id
	 * @param dentistaDTOHttp
	 * @return Objeto DTO do tipo DentistaDTO
	 */
	public DentistaDTO updateDentista(Long id, DentistaDTO dentistaDTOHttp) {
		
		dentistaDTO = new DentistaDTO();
		
		Dentista dentista = detistaRepository.findByIdAndNaoDeletado(id, true)
		        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro de dentista não encontrado. Pode ser alterado ou deletado."));
		
 
		dentista.setNomeCompleto(dentistaDTOHttp.getNomeCompleto());
		dentista.setRua(dentistaDTOHttp.getRua());
		dentista.setNumero(dentistaDTOHttp.getNumero());
		dentista.setBairro(dentistaDTOHttp.getBairro());
		dentista.setCidade(dentistaDTOHttp.getCidade());
		dentista.setEstado(dentistaDTOHttp.getEstado());
		dentista.setEmail(dentistaDTOHttp.getEmail());
		dentista.setDataNascimento(dentistaDTOHttp.getDataNascimento());
		dentista.setTelefoneResidencial(dentistaDTOHttp.getTelefoneResidencial());
		dentista.setTelefoneCelular(dentistaDTOHttp.getTelefoneCelular());
		dentista.setEspecialidade(dentistaDTOHttp.getEspecialidade());
		dentista.setCRO(dentistaDTOHttp.getCRO());
		dentista.setCpf(dentistaDTOHttp.getCpf());
		
		
		Dentista dadosAtualizado = detistaRepository.save(dentista);
		
		
		dentistaDTO.setNomeCompleto(dadosAtualizado.getNomeCompleto());
		dentistaDTO.setRua(dadosAtualizado.getRua());
		dentistaDTO.setNumero(dadosAtualizado.getNumero());
		dentistaDTO.setBairro(dadosAtualizado.getBairro());
		dentistaDTO.setCidade(dadosAtualizado.getCidade());
		dentistaDTO.setEstado(dadosAtualizado.getEstado());
		dentistaDTO.setEmail(dadosAtualizado.getEmail());
		dentistaDTO.setDataNascimento(dadosAtualizado.getDataNascimento());
		dentistaDTO.setTelefoneResidencial(dadosAtualizado.getTelefoneResidencial());
		dentistaDTO.setTelefoneCelular(dadosAtualizado.getTelefoneCelular());
		dentistaDTO.setEspecialidade(dadosAtualizado.getEspecialidade());
		dentistaDTO.setCRO(dadosAtualizado.getCRO());
		dentistaDTO.setCpf(dadosAtualizado.getCpf());
		
				
		return dentistaDTO;
	}


	 
	
	/**
	 * Método recebe em parâmetro um id para localizar o usuário e os dados para serem atualizados no
	 * corpo da requisição como em formato de um objeto UsuarioDTO.
	 * 
	 * Realizado instancia de um UsuarioDTO para autenticar os dados e seus tipos, realizado uma busca
	 * pelo paciente pelo id, caso id não encontrado é lançado um Exception do tipo ResponseStatusException
	 * para retornar uma mensagem HTTP para o navegador no código 404 e a mensagem de orientação.
	 * 
	 * Realiza a atualização desse usuario encontrado como os novos dados atualizados da request e salva-os
	 * na base de dados e por fim realiza a transformação dos dados salvos em um objeto DTO para ser retornado
	 * para o controler.
	 * 
	 * @param id
	 * @param dentistaDTOHttp
	 * @return Objeto DTO do tipo DentistaDTO
	 */
	public UsuarioDTO updateUsuario(Long id, UsuarioDTO usuarioDTOHttp) {
		
		usuarioDTO = new UsuarioDTO();
		
		Usuario usuario = usuarioRepository.findAllByIdAndNaoDeletado(id, true)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro de usuário não encontrado. Pode ser alterado ou deletado."));

		
		usuario.setUsuario(usuarioDTOHttp.getUsuario());
		usuario.setSenha(usuarioDTOHttp.getSenha());
		usuario.setEmail(usuarioDTOHttp.getEmail());
		
		Usuario usuarioAtualizado = usuarioRepository.save(usuario);
		
		usuarioDTO.setUsuario(usuarioAtualizado.getUsuario());
		usuarioDTO.setSenha(usuarioAtualizado.getSenha());
		usuarioDTO.setEmail(usuarioAtualizado.getEmail());
		
		
		return usuarioDTO;
	}
	
	
	
	
}
