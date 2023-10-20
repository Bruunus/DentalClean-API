package br.com.spring.dentalclean.controller;

import java.net.URI;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.spring.dentalclean.dto.DentistaDTO;
import br.com.spring.dentalclean.dto.PacienteDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class CriarControllerTest {	

		
	@Autowired
	private MockMvc postman;
	
	
	/**
	 * Classe(s) testada(s): CriarController
	 * Método(s) testado(s): cadastroDePaciente(@RequestBody PacienteDTO pacienteDTO)
	 * Objetivo do teste: O teste precisa passar com mensagem 200 OK!
	 * 
	 * Teste do controller de cadastro de paciente.
	 * Criando um URL e a simulação de um arquivo JSON em formato String
	 * enviamos para o controller com todos os dados através do MockMvc.
	 * 
	 * @throws Exception
	 */
	@Test
	public void deveCadastrarOsDadosDePacienteEDevolverStatusCode200() throws Exception {
		
		URI url = new URI("/api/cadastro/paciente");
		
		String JSON = "{" 
				+ "\"nomeCompleto\": \"Cascavel dos Santos\","
				+ "\"dataNascimento\": \"1988-05-22\","
				+ "\"genero\": \"Masculino\","
				+ "\"rua\" : \"Jucelino Bill\","
				+ "\"numero\" :"+40+","
				+ "\"bairro\" : \"Vila do Tijolo\","
				+ "\"cidade\" : \"São Paulo\","
				+ "\"estado\" : \"SP\","
				+ "\"email\" : \"bruno.inco@mail.com\","
				+ "\"convenio\" : \"Amil Dental\","
				+ "\"numeroCarteirinha\" :"+13548				 
				+"}";	
		
		
			postman.perform(
					MockMvcRequestBuilders.post(url)
					.content(JSON)
					.contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers
					.status()
					.is(200));		
	}
	
	
	
	
	/**
	 * Classe(s) testada(s): CriarController
	 * Método(s) testado(s): cadastroDeDentista(@RequestBody DentistaDTO cadastroDentistaDTO)
	 * Objetivo do teste: O teste precisa passar com mensagem 200 OK!
	 * 
	 * Teste do controller de cadastro de dentista.
	 * Criando um URL e a simulação de um arquivo JSON em formato String
	 * enviamos para o controller com todos os dados através do MockMvc.
	 * 
	 * @throws Exception
	 */
	@Test
	public void deveCadastrarOsDadosDeDentistaEDevolverStatusCode200() throws Exception {
		
		URI url = new URI("/api/cadastro/dentista");
		
		String JSON = "{" 				
				+ "\"rua\": \"Rua das Flores\","
				+ "\"numero\":"+1355+","
				+ "\"bairro\" : \"Bairro Central\","
				+ "\"cidade\" : \"São Paulo\","
				+ "\"estado\" : \"SP\","
				+ "\"nomeCompleto\": \"Lucas Mendes\","
				+ "\"email\" : \"lucas.mendes@mail.com\","
				+ "\"dataNascimento\":\"1986-07-18\","
				+ "\"telefoneResidencial\" : \"(11) 3657-4512\","
				+ "\"telefoneCelular\" : \"(11) 98745-1548\","	
				+ "\"especialidade\" : \"Ortodontia e ortopedia facial\","
				+ "\"cro\" : \"5678\","
				+ "\"cpf\" : \"468.941.058-42\""
				+"}";	
		
		
			postman.perform(
					MockMvcRequestBuilders.post(url)
					.content(JSON)
					.contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers
					.status()
					.is(200));		
	}
	
	
	
	
	
	@Test
	public void deveCadastrarOsDadosDeUsuarioEDevolverStatusCode200() throws Exception {
		
		URI url = new URI("/api/cadastro/usuario");
		
		String JSON = "{" +
							"\"usuario\":\"Fernandes\"," +
							"\"senha\": \"fer-123\", " +
							"\"email\" : \"fer_35@mail.com\"" +
					  "}";
		
		postman.perform(
				MockMvcRequestBuilders.post(url)
					.content(JSON)
					.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers
						.status()
						.is(200));
	}
	
	
}
