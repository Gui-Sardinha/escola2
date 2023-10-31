package Escola2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

import Escola2.entities.Materia;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class Escola2ApplicationTests {
	
	@Autowired
	private WebTestClient webTestClient;

	@Test
	void testCreateMateriaSuccess() {
		var materia = new Materia(null, "Estrutura de dados");
		
		
		webTestClient
		.post()
		.uri("/materias")
		.bodyValue(materia)
		.exchange()
		.expectStatus().isCreated()
		.expectBody()
		.jsonPath("$").isMap()
		.jsonPath("$.length()").isEqualTo(2)
		.jsonPath("$.nome").isEqualTo(materia.getNome());
		
	}
	
	
	@Test
	void testCreateMateriaFailure() {
		webTestClient
		.post()
		.uri("/materias")
		.bodyValue(
				new Materia(null, ""))
		.exchange()
		.expectStatus().is5xxServerError();
		
	}

}
