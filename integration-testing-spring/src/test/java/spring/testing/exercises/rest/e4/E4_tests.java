package spring.testing.exercises.rest.e4;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.servlet.ServletContext;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import spring.testing.server.configuration.ExchangeControllerConfiguration_WithMocks;
import spring.testing.server.controllers.ExchangeStatus;
import spring.testing.server.controllers.ProductExchangeController;
import spring.testing.server.persistence.jdbc.RateRepository;

@SpringBootTest
@ContextConfiguration(classes= {ExchangeControllerConfiguration_WithMocks.class })
@AutoConfigureMockMvc
public class E4_tests {

	@MockBean RateRepository mockRepository;
	@MockBean ExchangeStatus mockMonitor;
	@Autowired MockMvc mockMvc;
	
	@Test
	public void getAllRates_whenMonitored_returnsNotImplemented() throws Exception {

	}

	
}
