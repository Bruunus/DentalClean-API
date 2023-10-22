package br.com.spring.dentalclean.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.spring.dentalclean.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

	

	/**
	 * Busca avançada por parâmetro usanto JPQL. Retorna todos os registros de usuario que tenha
	 * o id passado e que o campo 'naoDeletado' tenha um booleano verdadeiro ou falso.
	 * 
	 * @param ids
	 * @param naoDeletado
	 * @return
	 */
	@Query("SELECT u FROM usuario u WHERE u.id IN :id AND u.naoDeletado = :naoDeletado")
    List<Usuario> queryFindByIdAndNaoDeletado(@Param("id") List<Long> ids, @Param("naoDeletado") Boolean naoDeletado);

	
	
	
	/**
	 * Busca todos os usuários que estão devidamente cadastrados no sistema.
	 * @return
	 */
	List<Usuario> findByNaoDeletado(Boolean b);



	/**
	 * Busca um usuario pelo id e que estava devidamento cadastrado no sistema.
	 * @param id
	 * @param b
	 * @return
	 */
	Optional<Usuario> findAllByIdAndNaoDeletado(Long id, boolean b);



	/**
	 * Validador para verificar se o valor foi excluído em modo falso.
	 * @param id
	 * @param b
	 * @return
	 */
	Optional<Usuario> findById(Long id);

	
}
