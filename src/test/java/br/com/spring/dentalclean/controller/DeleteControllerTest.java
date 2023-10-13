package br.com.spring.dentalclean.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.annotation.RequestParam;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class DeleteControllerTest {

	@Autowired
	private MockMvc postman;
	
	
	
	
	/**
	 * Classe(s) testada(s): DeleteController
	 * Método(s) testado(s): deletePacienteForIdFalso(@RequestParam("ids") List<Long> id)
	 * Objetivo do teste: O teste precisa passar com mensagem 200 OK - Indicando que os itens da
	 * lista estão presentes no banco de dados e foram deletados.
	 * 
	 * Criado uma url de teste simulando a url original com URI. Criado um lista do tipo Long 
	 * com os items representando os ids que estão presentes no banco de dados para serem 
	 * excluídos.
	 * 
	 * No método perform passado a url, inserido o tipo do contentType e chamado o método 
	 * param para passar a lista de ids por parâmetro conforme a exigência do controllador
	 * do tipo @DeleteMapping.
	 * 
	 * Retorna 200 caso os registros estejam presentes no banco de dados. 
	 * 
	 * @throws Exception
	 */
	@Test
	public void deveDeletarUmPacientePorUmaListaIdEmModoDeleteFalsoERetornar200() throws Exception {
		
		URI url = new URI("/api/delete/paciente");
		
		List<Long> list = new ArrayList<>();
		
		list.add((long) 6);
		
		
		postman.perform(delete(url)
				.contentType(MediaType.APPLICATION_JSON)
				.param("ids", list.stream().map(Object::toString).collect(Collectors.joining(","))))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(200));	
		
	}
	
	
	
	
	/**
	 * Classe(s) testada(s): DeleteController
	 * Método(s) testado(s): deleteAutenticoIDPaciente(@RequestParam("ids") List<Long> id) 
	 * Objetivo do teste: O teste precisa passar com mensagem 200 OK - Indicando que os itens da
	 * lista estão presentes no banco de dados e foram deletados de forma autentica.
	 * 
	 * Criado uma url de teste simulando a url original com URI. Criado um lista do tipo Long 
	 * com os items representando os ids que estão presentes no banco de dados para serem 
	 * excluídos.
	 * 
	 * No método perform passado a url, inserido o tipo do contentType e chamado o método 
	 * param para passar a lista de ids por parâmetro conforme a exigência do controllador
	 * do tipo @DeleteMapping.
	 * 
	 * Retorna 200 caso os registros estejam presentes no banco de dados. 
	 * 
	 * @throws Exception
	 */
	@Test
	public void deveDeletarUmPacientePorUmaListaDeIdsEmModoDeleteAutentico() throws Exception {
		
		URI url = new URI("/api/delete_aut/paciente");
		
		List<Long> list = new ArrayList<>();
		
		list.add((long) 10);  // verificar se o registro existe, do contrário dará erro
		
		postman.perform(delete(url)
				.contentType(MediaType.APPLICATION_JSON)
				.param("ids", list.stream().map(Object::toString).collect(Collectors.joining(","))))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(200));			
	}
	
	
	
	
	
	/**
	 * Classe(s) testada(s): DeleteController
	 * Método(s) testado(s): deleteDentistaForIdFalso(@RequestParam("ids") List<Long> id)
	 * Objetivo do teste: O teste precisa passar com mensagem 200 OK - Indicando que os itens da
	 * lista estão presentes no banco de dados e foram deletados de forma autentica.
	 * 
	 * Criado uma url de teste simulando a url original com URI. Criado um lista do tipo Long 
	 * com os items representando os ids que estão presentes no banco de dados para serem 
	 * excluídos.
	 * 
	 * No método perform passado a url, inserido o tipo do contentType e chamado o método 
	 * param para passar a lista de ids por parâmetro conforme a exigência do controllador
	 * do tipo @DeleteMapping.
	 * 
	 * Retorna 200 caso os registros estejam presentes no banco de dados. 
	 * 
	 * @throws Exception
	 */
	@Test
	public void deveDeletarUmDentistaPorUmaListaDeIdFalsoERetornar200() throws Exception {
		
		URI url = new URI("/api/delete_aut/paciente");
		
		List<Long> list = new ArrayList<>();
		
		list.add((long) 1);
		list.add((long) 2);
		list.add((long) 3);
		
		postman.perform(delete(url)
				.contentType(MediaType.APPLICATION_JSON)
				.param("ids", list.stream().map(Object::toString).collect(Collectors.joining(","))))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(200));	
		
	}
	
	
	
	/**
	 * Classe(s) testada(s): DeleteController
	 * Método(s) testado(s): deleteAutenticoIDPaciente(@RequestParam("ids") List<Long> id) 
	 * Objetivo do teste: O teste precisa passar com mensagem 200 OK - Indicando que os itens da
	 * lista estão presentes no banco de dados e foram deletados de forma autentica.
	 * 
	 * Criado uma url de teste simulando a url original com URI. Criado um lista do tipo Long 
	 * com os items representando os ids que estão presentes no banco de dados para serem 
	 * excluídos.
	 * 
	 * No método perform passado a url, inserido o tipo do contentType e chamado o método 
	 * param para passar a lista de ids por parâmetro conforme a exigência do controllador
	 * do tipo @DeleteMapping.
	 * 
	 * Retorna 200 caso os registros estejam presentes no banco de dados. 
	 * 
	 * @throws Exception
	 */
	@Test
	public void deveDeletarUmDentistaPorUmaListaDeIdsEmModoDeleteAutentico() throws Exception {
		
		URI url = new URI("/api/delete_aut/dentista");
		
		List<Long> list = new ArrayList<>();
		
		list.add((long) 10);
		
		postman.perform(delete(url)
				.contentType(MediaType.APPLICATION_JSON)
				.param("ids", list.stream().map(Object::toString).collect(Collectors.joining(","))))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(200));			
	}
	
	
	
	
	/**
	 * Classe(s) testada(s): DeleteController
	 * Método(s) testado(s): deletePacienteForIdFalso(@RequestParam("ids") List<Long> id)
	 * Objetivo do teste: O teste precisa passar com mensagem 200 OK - Indicando que os itens da
	 * lista estão presentes no banco de dados e foram deletados.
	 * 
	 * Criado uma url de teste simulando a url original com URI. Criado um lista do tipo Long 
	 * com os items representando os ids que estão presentes no banco de dados para serem 
	 * excluídos.
	 * 
	 * No método perform passado a url, inserido o tipo do contentType e chamado o método 
	 * param para passar a lista de ids por parâmetro conforme a exigência do controllador
	 * do tipo @DeleteMapping.
	 * 
	 * Retorna 200 caso os registros estejam presentes no banco de dados. 
	 * 
	 * @throws Exception
	 */
	@Test
	public void deveDeletarUmUsuarioPorUmaListaIdEmModoDeleteFalsoERetornar200() throws Exception {
		
		URI url = new URI("/api/delete/usuario");
		
		List<Long> list = new ArrayList<>();
		
		list.add((long) 1);
		list.add((long) 2);
		list.add((long) 3);
		
		
		postman.perform(delete(url)
				.contentType(MediaType.APPLICATION_JSON)
				.param("ids", list.stream().map(Object::toString).collect(Collectors.joining(","))))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(200));	
		
	}

}
