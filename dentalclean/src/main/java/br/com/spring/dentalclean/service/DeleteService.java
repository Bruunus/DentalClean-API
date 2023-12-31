package br.com.spring.dentalclean.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

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
public class DeleteService {

	@Autowired
	PacienteRepository pacienteRepository;

	@Autowired
	DentistaRepository dentistaRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;

	Paciente paciente;

	List<Paciente> optional;

	PacienteDTO pacienteDTO;

	DentistaDTO dentistaDTO;
	
	UsuarioDTO usuarioDTO;

	public DeleteService() {}
	

	
	/**
	 * Método de serviço para deletar um paciente por meio de delete falso.
	 * Realizado um update na coluna naoDeletado para 'false' indicando que ele está
	 * deletado da tabela.
	 * 
	 * 
	 * Realiza update
	 * 
	 * @param id
	 * @return
	 */
	public PacienteDTO deletePacientePorIdFalse(List<Long> id) {

		Iterable<Paciente> buscaDataBase = pacienteRepository.findAllById(id);

		buscaDataBase.forEach(data -> {
			System.out.println(data);
			data.setNaoDeletado(false);
			pacienteRepository.save(data);
		});

		boolean hasNonDeleted = StreamSupport.stream(buscaDataBase.spliterator(), false)
				.anyMatch(paciente -> paciente.getNaoDeletado());

		// Se tiver elemento como 'true'
		if (hasNonDeleted) {
			throw new RuntimeException("Erro ao deletar alguns registros.");
		}

		return pacienteDTO;
	}

	
	
	/**
	 * Método de serviço para deletar um dentista por meio de delete falso.
	 * Realizado um update na coluna naoDeletado para 'false' indicando que ele está
	 * deletado da tabela.
	 * 
	 * 
	 * Realiza update
	 * 
	 * @param cro
	 * @return
	 */
	public DentistaDTO deleteDentistaPorCroFalse(List<Integer> cro) {

		List<Integer> idsHttp = cro;

		Iterable<Dentista> loadRegistersDatabase = dentistaRepository.findByCroAndNaoDeletado(idsHttp, true);

		loadRegistersDatabase.forEach(data -> {
			System.out.println(data);
			data.setNaoDeletado(false);
			dentistaRepository.save(data);
		});

		boolean hasNonDeleted = StreamSupport.stream(loadRegistersDatabase.spliterator(), false)
				.anyMatch(dentista -> dentista.getNaoDeletado());

		// Se tiver elemento como 'true'
		if (hasNonDeleted) {
			throw new RuntimeException("Erro ao deletar alguns registros.");
		}

		return dentistaDTO;

	}
	
	
	
	/**
	 * Método de serviço para deletar um usuario por meio de delete falso.
	 * Realizado um update na coluna naoDeletado para 'false' indicando que ele está
	 * deletado da tabela.
	 * 
	 * 
	 * Realiza update
	 * 
	 * @param id
	 * @return
	 */
	public UsuarioDTO deleteUsuarioPorIdFalse(List<Long> id) {
		
		List<Long> idsHttp = id;

		Iterable<Usuario> loadRegistersDatabase = usuarioRepository.findAllById(idsHttp);

		loadRegistersDatabase.forEach(data -> {
			System.out.println(data);
			data.setNaoDeletado(false);
			usuarioRepository.save(data);
		});

		boolean hasNonDeleted = StreamSupport.stream(loadRegistersDatabase.spliterator(), false)
				.anyMatch(usuario -> usuario.getNaoDeletado());

		// Se tiver elemento como 'true'
		if (hasNonDeleted) {
			throw new RuntimeException("Erro ao deletar alguns registros.");
		}
		
		return usuarioDTO;
	}
	
	
		
	
	/**
	 * Deleta um paciente de forma autentica por id, os registros serão excluídos
	 * permanentemente.
	 * @param id
	 * @return
	 */
	public Boolean deletePacienteAutenticoPorId(List<Long> id) {

		try {
			
			List<Long> idsHttp = id;

			idsHttp.forEach(ids -> {
				Optional<Paciente> idsBanco = pacienteRepository.findById(ids);
				if (idsBanco.isPresent()) {
					pacienteRepository.deleteById(ids);
				}
			});

			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

		
	
	/**
	 * Deleta um dentista de forma autentica por id, os registros serão excluídos
	 * permanentemente.
	 * @param cro
	 * @return
	 */
	@Transactional
	public Boolean deleteDentistaAutenticoPorId(List<Integer> cro) {
		
		
		try {

			List<Integer> croHttp = cro;

			croHttp.forEach(cros -> {
				Optional<Dentista> idsBanco = dentistaRepository.findByCro(cros);
				if (idsBanco.isPresent()) {
					dentistaRepository.deleteByCro(cros);
				}
			});

			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

	 
		
		
	}
	
	
	
	
	
	/**
	 * Método de serviço validador que realiza consulta no banco de dados e faz
	 * validação de igualdade com os dados que vem da request.
	 * 
	 * @param id
	 * @return Boolean
	 */
	public Boolean validadorPacienteDeletadoFalse(List<Long> idHttp) {

		 
		List<Long> printList = idHttp;

		 
		List<Paciente> list = pacienteRepository.queryFindByIdAndNaoDeletado(printList, false);

		// operação para validar se os dados são iguais
		boolean valoresIguais = list.stream()
				.map(Paciente::getId_cadastro_paciente)
				.collect(Collectors.toList())
				.equals(printList);

		if (valoresIguais) {
			System.out.println("\nController-log: Dados deletados com sucesso !!!");

			System.out.print("\n\tDeltados:\n\t[");
			list.forEach(i -> {
				System.out.print("" + i + " ");
			});
			System.out.println("]");

			return true;
		} else {
			System.out.println("\n\tController-log: Atenção ! Pode ser que alguns dados não foram gravados.");
			return false;
		}

	}

	
	
	
	/**
	 * Método de serviço validador que realiza consulta no banco de dados e faz
	 * validação de igualdade com os dados que vem da request.
	 * 
	 * @param id
	 * @return Boolean
	 */
	public Boolean validadorDentistaDeletadoFalse(List<Integer> idHttp) {

		 
		List<Integer> printList = idHttp;
		 
		List<Dentista> list = dentistaRepository.queryFindByCroAndNaoDeletado(printList, false);

		// operação para validar se os dados são iguais
		boolean valoresIguais = list.stream()
				.map(Dentista::getCro)
				.collect(Collectors.toList())
				.equals(printList);

		if (valoresIguais) {
			System.out.println("\nController-log: Dados deletados com sucesso !!!");

			System.out.print("\n\tDeltados:\n\t[");
			list.forEach(i -> {
				System.out.print("" + i + " ");
			});
			System.out.println("]");

			return true;
		} else {
			System.out.println("\n\tController-log: Atenção ! Pode ser que alguns dados não foram gravados.");
			return false;
		}

	}


	
	
	/**
	 * Método de serviço validador que realiza consulta no banco de dados e faz
	 * validação de igualdade com os dados que vem da request.
	 * 
	 * @param id
	 * @return Boolean
	 */
	public Boolean validadedeleteFalsoUsuario(List<Long> id) {

		// dados do http
		List<Long> printList = id;

		// dados do banco
		List<Usuario> list = usuarioRepository.queryFindByIdAndNaoDeletado(id, false);

		// operação para validar se os dados são iguais
		boolean valoresIguais = list.stream()
				.map(Usuario::getId)
				.collect(Collectors.toList())
				.equals(printList);

		if (valoresIguais) {
			System.out.println("\nController-log: Dados deletados com sucesso !!!");

			System.out.print("\n\tDeltados:\n\t[");
			list.forEach(i -> {
				System.out.print("" + i + " ");
			});
			System.out.println("]");

			return true;
		} else {
			System.out.println("\n\tController-log: Atenção ! Pode ser que alguns dados não foram gravados.");
			return false;
		}

	}


	
	
	

	
	
	
	
	

	
	
	
}
