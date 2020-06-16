package spring.testing.server.configuration;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;

import spring.testing.server.bills.LineItem;
import spring.testing.server.compliance.logging.Registrar;
import spring.testing.server.compliance.logging.TrafficRegistrar;
import spring.testing.server.exchange.CheeseExchange;
import spring.testing.server.exchange.Exchange;
import spring.testing.server.exchange.RateParser;
import spring.testing.server.gateway.ExchangeStatus;
import spring.testing.server.persistence.jdbc.RateRepository;
import spring.testing.server.rules.CalculationRule;
import spring.testing.server.rules.CompositeLineItemRule;

@Configuration
public class AppConfiguration {
	
	@Bean
	public RateRepository rateRepository() {
		return new RateRepository();
	}

	@Bean
	public CompositeLineItemRule compositeLineItemRule() {
		List<CalculationRule> rules = new ArrayList<>();
	    CalculationRule factorRule = new CalculationRule() {
	      public float getMultiplier(LineItem t) {
	        return 1.1f;
	      }
	    };
	    rules.add(factorRule);
	    
		return new CompositeLineItemRule(rules);
	};

	@Bean 
	public RateParser rateParser() {
		return new RateParser();
	}

	
	@Bean 
	public Exchange exchange() {
		return new CheeseExchange(rateRepository());
		
	}
	
	@Bean 
	public ExchangeStatus statusMonitor() {
		return new ExchangeStatus();
	}
	
	@Bean
	public Registrar trafficLogger( ) {
		return new TrafficRegistrar();
	}
}
