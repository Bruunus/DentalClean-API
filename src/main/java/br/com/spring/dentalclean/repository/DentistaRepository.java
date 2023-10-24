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
	Optional<Dentista> findByCro(Integer cro);
	
	
	
	/**
	 * Busca avançada por parâmetro usanto JPQL. Retorna o registro do dentista que tenha
	 * o CRO passado e que o campo 'naoDeletado' tenha um booleano verdadeiro ou falso.
	 * 
	 * @param ids
	 * @param naoDeletado
	 * @return
	 */
	@Query("SELECT d FROM dentista d WHERE d.cro IN :cro AND d.naoDeletado = :naoDeletado")
    List<Dentista> queryFindByCroAndNaoDeletado(@Param("cro") List<Integer> cros, @Param("naoDeletado") Boolean naoDeletado);

	
	
	/**
	 * Busca todos os registros que não estão deletados.
	 * @param pacientes
	 * @return
	 */
	List<Dentista> findByNaoDeletado(boolean b);
	
	
	

	/**
	 * Busca todos os registro pelo nome completo passade e que devidamente cadastrado no sistema.
	 * @param nome
	 * @param b
	 * @return
	 */
	List<Dentista> findByNomeCompletoContainingAndNaoDeletado(String nome, boolean b);



	/**
	 * Busca dentista pelo CRO e que esteja devidamente cadastrado no sistema.
	 * @param cro
	 * @param b
	 * @return
	 */
	Optional<Dentista> findByCroAndNaoDeletado(Integer cro, boolean b);
	
<<<<<<< HEAD
	
	
	/**
	 * Busca 
	 * @param cro
	 * @param b
	 * @return
	 */
	Iterable<Dentista> findByCroAndNaoDeletado(List<Integer> cro, boolean b);
=======

>>>>>>> ed8e8a12347cb490bdcb80451b99a11885561a9e



	void deleteByCro(Integer cros);







	 

}

