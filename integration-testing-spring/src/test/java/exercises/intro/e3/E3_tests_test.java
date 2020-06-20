package exercises.intro.e3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import spring.testing.server.compliance.ComplianceMonitor;
import spring.testing.server.compliance.logging.Registrar;
import spring.testing.server.controllers.ComplianceController;

@SpringBootTest
@ActiveProfiles("test")
public class E3_tests_test {

	@Autowired ComplianceController controller;
	@Autowired Registrar registrar;
	
	@BeforeEach
	public void setup() {
		ComplianceMonitor.instance().StartMonitoring();
	}
	
	@AfterEach
	public void teardown() {
		ComplianceMonitor.instance().StopMonitoring();
	}
	
	@Test
	public void whenLogIsTempered_getWarning() {
		assertEquals("data was tempered", controller.getTrafficLog());
	}
	
}
