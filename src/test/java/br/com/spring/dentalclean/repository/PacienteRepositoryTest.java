package br.com.spring.dentalclean.repository;

import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.server.ResponseStatusException;

import br.com.spring.dentalclean.model.Paciente;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)    // usar db configurado no sistema (MariaDB)
@ActiveProfiles("test")		// executar em modo teste com as configurações do application-test.properties
public class PacienteRepositoryTest {
	
	private static Boolean naoDeletado;
	
	@Autowired
	PacienteRepository pacienteRepository;	
 
	
	 
	/**
	 * Classe(s) testada(s): UpdadeService
	 * Método(s) testado(s): updatePaciente(Long id, PacienteDTO pacienteDTOHttp)
	 * Objetivo do teste: O teste precisa passar
	 * 
	 * Pesquisa o id do paciente para em seguida realizar o update. O teste é que na pesquisa 
	 * a variável pacienteRepository não pode vir nula e o id passado precisa vir com o mesmo
	 * nome do registro respectivo ao id.
	 * 
	 */
	@Test
	public void deveAcharUmRegistroPassadoPorIdEQueOValorDaColunaNaoDeletadoEstejaComoTrue() {
		
		// dados para teste iguais a um registro qualquer
		Long id = (long) 6;
		String nomeDoRegistro = "Gabriel Costa dos Santos";	
		
		
		Paciente paciente = pacienteRepository.findByIdAndNaoDeletado(id, true)
		        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Registro de dentista não encontrado. Pode ser alterado ou deletado"));

		 		
		Assert.assertNotNull("Falha de teste: O método findByIdAndNaoDeletado está vazio !", paciente);
		Assert.assertEquals("Falha de teste: Os nomes não são idênticos !", nomeDoRegistro, paciente.getNomeCompleto());
		
		System.out.println("JUnit: Teste passado com sucesso !!!");
		 
	}
	
	
	/**
	 * Classe(s) testada(s): DeleteService
	 * Método(s) testado(s): validadorPacienteDeletadoFalse(List<Long> idHttp)
	 * Objetivo do teste: O teste precisa passar
	 * 
	 * Teste realizado com o método queryFindByIdAndNaoDeletado que recebe uma lista de ids
	 * simulando os ids vindo da requisição. Em primiero ponto pe verificado se o método 
	 * queryFindByIdAndNaoDeletado não está vindo vazio buscando os dados no banco de dados
	 * e em seguida é verificado cada elemento do retorno do método queryFindByIdAndNaoDeletado 
	 * de modo manual. Se um único elemento não atender a requisição o teste falha.
	 * 
	 */
	@Test
	public void deveAcharUmaListaDeIdsEQueOValorDaColunaNaoDeletadoEstejaComoTrue() {
		
		List<Long> listaDeIds = new ArrayList<>();
		listaDeIds.add((long) 10);
		listaDeIds.add((long) 11);
		listaDeIds.add((long) 12);
		
		naoDeletado = false;
		
		List<Paciente> list = pacienteRepository.queryFindByIdAndNaoDeletado(listaDeIds, naoDeletado);
		
		assertFalse("Falha de teste: A lista 'list' está vazia !", !list.isEmpty());
		
		for (Paciente paciente : list) {
            assertFalse("Falha de teste: Um ou mais registros não foi deletado !", paciente.getNaoDeletado());
        }	
		
		System.out.println("JUnit: Teste passado com sucesso !!!");
		
	}
	
	/**
	 * 
	 */
	@Test
	public void deveAcharUmRegistroEspecificoPelaColunaNomeCompleto() {
		
		String nome = "Pedro";  //nome precisa estar ativo (nao_deletado)
		naoDeletado = false;
		
		List<Paciente> paciente = pacienteRepository.findByNomeCompletoContainingAndNaoDeletado(nome, false);
		
		
		Assert.assertFalse("Falha de teste: Nome não existe ou não está deletado!", !paciente.isEmpty());
		
		paciente.forEach(data -> {
			
			Assert.assertEquals("Falha de teste: Alguns nomes não foram recuperados!",nome, data.getNomeCompleto());
			Assert.assertEquals("Falha de teste: Algum registro não está deletado!",naoDeletado, data.getNaoDeletado());
		});
		
		
		System.out.println("JUnit: Teste passado com sucesso !!!");

		
	}
	
	
	
	 


}

