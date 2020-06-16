package spring.testing.server.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.testing.server.compliance.ComplianceMonitor;
import spring.testing.server.compliance.logging.Registrar;
import spring.testing.server.compliance.logging.TrafficRegistrar;
import spring.testing.server.rules.CompositeLineItemRule;

@Controller
public class ComplianceController {
	@Autowired Registrar trafficRegistrar;

	@RequestMapping(method = RequestMethod.POST, value = "rules/apply")
	public void applyComplianceRules() {
		if (ComplianceMonitor.instance().shouldMonitor()) {
			trafficRegistrar.start();
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "rules/log")
	public String getTrafficLog() {
		if (ComplianceMonitor.instance().shouldMonitor()){
			return trafficRegistrar.getLog().getAllAsString();
		}
		else
			return "Monitoring is offline";
	}
	
}
