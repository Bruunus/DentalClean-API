package br.com.spring.dentalclean.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class ListarService {

	private PacienteDTO pacienteDTO; 
	
	private DentistaDTO dentistaDTO;
	
	private UsuarioDTO usuarioDTO;
	
	@Autowired
	PacienteRepository pacienteRepository;
	
	@Autowired
	DentistaRepository dentistaRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	
	
	/**
	 * Lista todos os pacientes no banco que estão atualmente cadastrados no sistema. 
	 * @return
	 */
	public List<PacienteDTO> listarTodosPacientes() {		
		
		List<Paciente> pacientes = 
				(List<Paciente>) pacienteRepository.findByNaoDeletado(true);
		
		List<PacienteDTO> listaDeDados = new ArrayList<>();
		
		
		pacientes.forEach(paciente -> {
			pacienteDTO = new PacienteDTO();
			
			 
			pacienteDTO.setNomeCompleto(paciente.getNomeCompleto());
			pacienteDTO.setDataNascimento(paciente.getDataNascimento());
			pacienteDTO.setGenero(paciente.getGenero());
			pacienteDTO.setEmail(paciente.getEmail());
			pacienteDTO.setConvenio(paciente.getConvenio());
			pacienteDTO.setNumeroCarteirinha(paciente.getNumeroCarteirinha());
			pacienteDTO.setRua(paciente.getRua());
			pacienteDTO.setNumero(paciente.getNumero());
			pacienteDTO.setBairro(paciente.getBairro());
			pacienteDTO.setCidade(paciente.getCidade());
			pacienteDTO.setEstado(paciente.getEstado());
			
			listaDeDados.add(pacienteDTO);
		});
		
		return listaDeDados;
	}



	/**
	 * Lista todos os destistas no banco que estão atualmente cadastrados no sistema. 
	 * @return
	 */
	public List<DentistaDTO> listarTodosDentistas() {
		
		List<Dentista> destistas = 
				(List<Dentista>) dentistaRepository.findByNaoDeletado(true);
		
		List<DentistaDTO> listaDeDados = new ArrayList<>();
		
		
		destistas.forEach(dentista -> {
			dentistaDTO = new DentistaDTO();
			
			dentistaDTO.setId(dentista.getId());
			dentistaDTO.setNomeCompleto(dentista.getNomeCompleto());
			dentistaDTO.setRua(dentista.getRua());
			dentistaDTO.setNumero(dentista.getNumero());
			dentistaDTO.setBairro(dentista.getBairro());
			dentistaDTO.setCidade(dentista.getCidade());
			dentistaDTO.setEstado(dentista.getEstado());
			dentistaDTO.setEmail(dentista.getEmail());
			dentistaDTO.setDataNascimento(dentista.getDataNascimento());
			dentistaDTO.setTelefoneResidencial(dentista.getTelefoneResidencial());
			dentistaDTO.setTelefoneCelular(dentista.getTelefoneCelular());
			dentistaDTO.setEspecialidade(dentista.getEspecialidade());
			dentistaDTO.setCRO(dentista.getCRO());
			dentistaDTO.setCpf(dentista.getCpf());
			
			listaDeDados.add(dentistaDTO);
		});		
		
		return listaDeDados;
	}
	
	
	
	
	/**
	 * Lista todos os usuarios no banco que estão atualmente cadastrados no sistema. 
	 * @return
	 */
	public List<UsuarioDTO> listarTodosUsuarios() {
		
		List<Usuario> usuarios = (List<Usuario>) usuarioRepository.findByNaoDeletado(true);
		
		List<UsuarioDTO> listUsuarioDTO = new ArrayList<>();
		
		usuarios.forEach(data -> {
			usuarioDTO = new UsuarioDTO();
			
			usuarioDTO.setUsuario(data.getUsuario());
			usuarioDTO.setSenha(data.getSenha());
			usuarioDTO.setEmail(data.getEmail());
			
			listUsuarioDTO.add(usuarioDTO);
			
		});		
		
		return listUsuarioDTO;
	}




	/**
	 * Lista pacientes pela string passada e pesquisa na coluna nomeCompleto e que estejam cadastrados.
	 * 
	 * @return
	 */
	public List<PacienteDTO> listaPacientePorCadeiraDeCaracter(String nome) {		
	
		List<Paciente> paciente = 
				(List<Paciente>) pacienteRepository.findByNomeCompletoContainingAndNaoDeletado(nome, true);
		
		List<PacienteDTO> pacienteDTOList  = new ArrayList<>();
		
		if (!paciente.isEmpty()) {			
			
			paciente.forEach(data -> {
				
				pacienteDTO = new PacienteDTO();
				
				pacienteDTO.setId(data.getId_cadastro_paciente());
				pacienteDTO.setNomeCompleto(data.getNomeCompleto());
				pacienteDTO.setDataNascimento(data.getDataNascimento());
				pacienteDTO.setGenero(data.getGenero());
				pacienteDTO.setEmail(data.getEmail());
				pacienteDTO.setConvenio(data.getConvenio());
				pacienteDTO.setNumeroCarteirinha(data.getNumeroCarteirinha());
				pacienteDTO.setRua(data.getRua());
				pacienteDTO.setNumero(data.getNumero());
				pacienteDTO.setBairro(data.getBairro());
				pacienteDTO.setCidade(data.getCidade());
				pacienteDTO.setEstado(data.getEstado());
				
				pacienteDTOList.add(pacienteDTO);
				
			});		 
			
			return pacienteDTOList;
			
		} else {
			
			return pacienteDTOList;

		}
		 
		 
	}



	/**
	 * Lista dentista pela string passada e pesquisa na coluna nomeCompleto e que estejam cadastrados.
	 * 
	 * @return
	 */
	public List<DentistaDTO> listaDentistaPorCadeiaDeCaracter(String nome) {
		
		List<Dentista> dentista = dentistaRepository.findByNomeCompletoContainingAndNaoDeletado(nome, true);
		
		List<DentistaDTO> dentistaDTOList = new ArrayList<>();
		
		if (!dentista.isEmpty()) {
			dentista.forEach(data -> {
				
				dentistaDTO = new DentistaDTO();

				dentistaDTO.setId(data.getId());
				dentistaDTO.setNomeCompleto(data.getNomeCompleto());
				dentistaDTO.setRua(data.getRua());
				dentistaDTO.setNumero(data.getNumero());
				dentistaDTO.setBairro(data.getBairro());
				dentistaDTO.setCidade(data.getCidade());
				dentistaDTO.setEstado(data.getEstado());
				dentistaDTO.setEmail(data.getEmail());
				dentistaDTO.setDataNascimento(data.getDataNascimento());
				dentistaDTO.setTelefoneResidencial(data.getTelefoneResidencial());
				dentistaDTO.setTelefoneCelular(data.getTelefoneCelular());
				dentistaDTO.setEspecialidade(data.getEspecialidade());
				dentistaDTO.setCRO(data.getCRO());
				dentistaDTO.setCpf(data.getCpf());

				dentistaDTOList.add(dentistaDTO);

			});
			
			return dentistaDTOList; // com dados
		} else {
			return dentistaDTOList; // vazio - será tratado no controller
		}
		
		
	}




	
	




    
    

}
