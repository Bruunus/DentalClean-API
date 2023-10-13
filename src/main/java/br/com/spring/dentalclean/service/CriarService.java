package br.com.spring.dentalclean.service;

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
public class CriarService {
	
	@Autowired
	private PacienteRepository pacienteRepository;

	@Autowired
	private DentistaRepository dentistaRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

 
	
	
	
	/**
	 * Método realiza o cadastramento de um novo paciente no banco de dados.
	 * Recebe os dados enviados pela requisição e são adicionados à entidade 
	 * do tipo Paciente e por fim é realizado o salvamento no banco de dados.
	 * 
	 * @param pacienteDTO
	 * @return Objeto do tipo PacienteDTO
	 */
	public PacienteDTO cadastrarPaciente(PacienteDTO pacienteDTO) {		
		
		
		Paciente cadastro = new Paciente();
		cadastro.setNaoDeletado(true);
		cadastro.setNomeCompleto(pacienteDTO.getNomeCompleto());
		cadastro.setDataNascimento(pacienteDTO.getDataNascimento());
		cadastro.setGenero(pacienteDTO.getGenero());
		cadastro.setEmail(pacienteDTO.getEmail());
		cadastro.setConvenio(pacienteDTO.getConvenio());
		
		
		
		if (!(pacienteDTO.getNumeroCarteirinha() == null)) {
			cadastro.setNumeroCarteirinha(pacienteDTO.getNumeroCarteirinha());
        } else {
        	throw new NullPointerException("A variável 'nome' é nula.");
        }
		
		
		
		
		
		cadastro.setRua(pacienteDTO.getRua());
		
		
		String numeroString = pacienteDTO.getNumero();
		Integer numeroInteger = pacienteDTO.conversorInteger(numeroString);		
		cadastro.setNumero(numeroInteger);
		
		
		cadastro.setBairro(pacienteDTO.getBairro());
		cadastro.setCidade(pacienteDTO.getCidade());
		cadastro.setEstado(pacienteDTO.getEstado());
		
		pacienteRepository.save(cadastro);
		
		
		return pacienteDTO;
	}
	
	
	
	
	
	/**
	 * Método realiza o cadastramento de um novo dentista no banco de dados.
	 * Recebe os dados enviados pela requisição e são adicionados à entidade 
	 * do tipo Dentista e por fim é realizado o salvamento no banco de dados.
	 * 
	 * @param cadastroDentistaDTO
	 * @return Objeto do tipo DentistaDTO
	 */
	public DentistaDTO cadastrarDentista(DentistaDTO cadastroDentistaDTO) {
		
		Dentista cadastro = new Dentista();
		
		cadastro.setNaoDeletado(true);
		cadastro.setNomeCompleto(cadastroDentistaDTO.getNomeCompleto());
		cadastro.setRua(cadastroDentistaDTO.getRua());
		cadastro.setNumero(cadastroDentistaDTO.getNumero());
		cadastro.setBairro(cadastroDentistaDTO.getBairro());
		cadastro.setCidade(cadastroDentistaDTO.getCidade());
		cadastro.setEstado(cadastroDentistaDTO.getEstado());
		cadastro.setEmail(cadastroDentistaDTO.getEmail());
		cadastro.setDataNascimento(cadastroDentistaDTO.getDataNascimento());
		cadastro.setTelefoneResidencial(cadastroDentistaDTO.getTelefoneResidencial());
		cadastro.setTelefoneCelular(cadastroDentistaDTO.getTelefoneCelular());
		cadastro.setEspecialidade(cadastroDentistaDTO.getEspecialidade());
		cadastro.setCRO(cadastroDentistaDTO.getCRO());
		cadastro.setCpf(cadastroDentistaDTO.getCpf());
		
		dentistaRepository.save(cadastro);
		
		return cadastroDentistaDTO;
	}





	/**
	 * Método realiza o cadastramento de um novo usuario no banco de dados.
	 * Recebe os dados enviados pela requisição e são adicionados à entidade 
	 * do tipo Usuario e por fim é realizado o salvamento no banco de dados.
	 * 
	 * @param usuarioDTO
	 * @return Objeto do tipo UsuarioDTO
	 */
	public UsuarioDTO cadastrarUsuario(UsuarioDTO usuarioDTO) {
		
		Usuario usuarioBaseDeDados = new Usuario();
		
		usuarioBaseDeDados.setNaoDeletado(true);
		usuarioBaseDeDados.setUsuario(usuarioDTO.getUsuario());
		usuarioBaseDeDados.setSenha(usuarioDTO.getSenha());
		usuarioBaseDeDados.setEmail(usuarioDTO.getEmail());
		
		usuarioRepository.save(usuarioBaseDeDados);
		
		return usuarioDTO;
		
	}

	
	
	
}
