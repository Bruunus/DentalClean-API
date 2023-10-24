package br.com.spring.dentalclean.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.spring.dentalclean.model.Paciente;

@Repository
public interface PacienteRepository extends CrudRepository<Paciente, Long> {
	
	
	
	/**
	 * Busca o paciente por id e que esteja devidamente cadastrado
	 */
	Optional<Paciente> findByIdAndNaoDeletado(Long id, Boolean b);

	
	/**
	 * Busca avançada por parâmetro usanto JPQL. Retorna todos os registros de paciente que tenha
	 * uma lista de id passado e que o campo 'naoDeletado' tenha um booleano verdadeiro ou falso.
	 * 
	 * @param ids
	 * @param naoDeletado
	 * @return
	 */
	@Query("SELECT p FROM paciente p WHERE p.id IN :id AND p.naoDeletado = :naoDeletado")
    List<Paciente> queryFindByIdAndNaoDeletado(@Param("id") List<Long> ids, @Param("naoDeletado") Boolean naoDeletado);


	/**
	 * Busca todos os registros que não estão deletados.
	 * @param pacientes
	 * @return
	 */
	List<Paciente> findByNaoDeletado(boolean pacientes);


		
	/**
	 * Busca paciente por qualquer String declarada que tenha na coluna nome_completo e
	 * que o dentista estava cadastrado.
	 * @param nome
	 * @return
	 */
	List<Paciente> findByNomeCompletoContainingAndNaoDeletado(String nome, Boolean b);
	
	
}
