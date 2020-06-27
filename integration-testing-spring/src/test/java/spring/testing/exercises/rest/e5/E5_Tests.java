package spring.testing.exercises.rest.e5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import spring.testing.server.configuration.JPA_ControllerConfiguration;
import spring.testing.server.configuration.ProductControllerConfiguration;
import spring.testing.server.controllers.ProductController;
import spring.testing.server.entities.Product;

@ContextConfiguration(classes = { ProductControllerConfiguration.class, JPA_ControllerConfiguration.class })
@SpringBootTest
@AutoConfigureMockMvc
public class E5_Tests {

	@Autowired
	MockMvc mockMvc;

	@PersistenceContext
	private EntityManager entityManager;

	@Test
	public void zeroRatesRetrieved_onCreation() throws Exception {
	}

	@Test
	@Transactional
	public void twoRatesRetrieved_afterAddingTwo() throws Exception {
	}
}