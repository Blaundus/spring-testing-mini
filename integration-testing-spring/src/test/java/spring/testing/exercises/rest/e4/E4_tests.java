package spring.testing.exercises.rest.e4;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import spring.testing.server.configuration.RatesControllerConfiguration_WithMocks;
import spring.testing.server.exchange.Monitor;
import spring.testing.server.persistence.jdbc.RateRepository;

@SpringBootTest
@ContextConfiguration(classes= {RatesControllerConfiguration_WithMocks.class })
@AutoConfigureMockMvc
public class E4_tests {

	@MockBean RateRepository mockRepository;
	@MockBean Monitor mockMonitor;
	@Autowired MockMvc mockMvc;
	
	@Test
	public void getAllRates_whenMonitored_returnsNotImplemented() throws Exception {

	}

	
}
