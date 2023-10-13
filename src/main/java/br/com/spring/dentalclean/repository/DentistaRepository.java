package br.com.spring.dentalclean.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.spring.dentalclean.model.Dentista;
import br.com.spring.dentalclean.model.Paciente;

@Repository
public interface DentistaRepository extends CrudRepository<Dentista, Long>{
	
	
	
	/**
	 * Busca de um dentista pelo id
	 */
	Optional<Dentista> findById(Long id);
	
	
	
	/**
	 * Busca avançada por parâmetro usanto JPQL. Retorna todos os registros de dentistas que tenha
	 * o id passado e que o campo 'naoDeletado' tenha um booleano verdadeiro ou falso.
	 * 
	 * @param ids
	 * @param naoDeletado
	 * @return
	 */
	@Query("SELECT d FROM dentista d WHERE d.id IN :id AND d.naoDeletado = :naoDeletado")
    List<Dentista> queryFindByIdAndNaoDeletado(@Param("id") List<Long> ids, @Param("naoDeletado") Boolean naoDeletado);

	
	
	/**
	 * Busca todos os registros que não estão deletados.
	 * @param pacientes
	 * @return
	 */
	List<Dentista> findByNaoDeletado(boolean b);
	
	
	

	/**
	 * Busca todos os registro pela String passade e que devidamente cadastrado no sistema.
	 * @param nome
	 * @param b
	 * @return
	 */
	List<Dentista> findByNomeCompletoContainingAndNaoDeletado(String nome, boolean b);



	/**
	 * Busca dentista pelo id e que esteja devidamente cadastrado no sistema.
	 * @param id
	 * @param b
	 * @return
	 */
	Optional<Dentista> findByIdAndNaoDeletado(Long id, boolean b);

}

