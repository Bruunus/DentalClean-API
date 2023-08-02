package br.com.spring.dentalclean.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.MvcResult;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestConnectionControllerTest {
	
	@Autowired
	private MockMvc postman;
	
	String contentAsString;

	
	/**
	 * This method have test request of type get for TestConnectionController
	 * 
	 * @throws Exception - Case have error in code of object URI
	 */
	@Test
	public void testForRequestTypeGet() throws Exception {
		
	   URI requestGet = new URI("/test/testConn") ;
	   boolean testPassed = false;
		try {
			contentAsString = postman.perform(MockMvcRequestBuilders.get(requestGet))
					.andExpect(MockMvcResultMatchers
							.status()
							.is(200))
					.andReturn()	
					.getResponse()	// pegar mensagem de retorno do controller
					.getContentAsString();
					
			 
			testPassed = true;
		} finally {
			if (testPassed) {
				System.out.println("\n\nTeste 1\n");
	            System.out.println("Teste de requisição GET passando com sucesso!");
	            System.out.println("\n\nMensagem do controller:\n\n\t"+contentAsString);
			} else {
	            System.err.println("Falha no teste de GET!");
	        }
		}
	}
	
	/**
	 * This method have test request of type post for TestConnectionController
	 * @throws Exception - Case have error in code of object URI
	 */
	@Test
	public void testForRequestTypePost() throws Exception {
		
		
		URI requestPost = new URI("/test/data");
		String JSON = "[\"Teste de requisição POST - Dev. Bruno\"]";
		
		boolean testPassed = false;
		
		try {
			postman
				.perform(MockMvcRequestBuilders
						.post(requestPost)
						.content(JSON)
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers
						.status()
						.is(200));
			
			testPassed = true;
		} finally {
	        if (testPassed) {
	        	System.out.println("\n\nTeste 2\n");
	            System.out.println("Teste de requisição POST passando com sucesso!");
	        } else {
	            System.err.println("Falha no teste de POST!");
	        }
		}
	}
	
	
	
	
	/**
	 * This method have test request of type post for TestConnectionController
	 * @throws Exception - Case have error in code of object URI
	 */
	@Test
	public void testForRequestTypePostInCollection() throws Exception {
		
		
		URI requestPost = new URI("/test/dataCollection");
		
		String JSON = "{" 
						+ "\"cadastro\": [" 				
							+"{"
								+"\"nome\":\"Bruno Fernandes\","
								+"\"profissao\":\"Desenvolvedor Java\""
							+"}"
						 +"]"
						+"}";	
					   
		
		boolean testPassed = false;
		
		try {
			postman
				.perform(MockMvcRequestBuilders
						.post(requestPost)
						.content(JSON)
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers
						.status()
						.is(200));
			
			testPassed = true;
		} finally {
	        if (testPassed) {
	        	System.out.println("\n\nTeste 3\n");
	            System.out.println("Teste de requisição com coleção passando com sucesso!");
	            System.out.println("\n\t"+JSON+"\n\n");
	        } else {
	            System.err.println("Falha no teste de POST com collecition!");
	        }
		}
	}
	
	
	
	
}
