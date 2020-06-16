package spring.testing.server.unittests.exchange;

import static org.mockito.Mockito.verify;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import spring.testing.server.exceptions.ParsingException;
import spring.testing.server.exchange.CheeseExchange;
import spring.testing.server.exchange.RateParser;

public class RateParserTests {
	private RateParser parser;
	@Mock
	private CheeseExchange mockExchange;

	@BeforeEach
	public void setUp() {
		parser = new RateParser();
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testIntegerRate() {
		parser.setExchangeRate("USD=2", mockExchange);
		verify(mockExchange).setRate("USD", BigDecimal.valueOf(2));
	}

	@Test
	public void testFractionRate() {
		parser.setExchangeRate("USD=0.5", mockExchange);
		verify(mockExchange).setRate("USD", BigDecimal.valueOf(0.5));
	}

	@Test
	public void testFloatRate() {
		parser.setExchangeRate("USD=2.5", mockExchange);
		verify(mockExchange).setRate("USD", BigDecimal.valueOf(2.5));
	}

	@Test
	public void testBadLinesIgnored() {
		assertThrows(ParsingException.class, () -> {
			parser.setExchangeRate("USDX=2.5", mockExchange);
		});
	}

}
