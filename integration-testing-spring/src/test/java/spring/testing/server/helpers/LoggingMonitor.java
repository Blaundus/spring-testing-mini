package spring.testing.server.helpers;

import spring.testing.server.controllers.ExchangeStatus;

public class LoggingMonitor extends ExchangeStatus {

	
	@Override
	public void startMonitoring() {
		super.startMonitoring();
	}
	
	@Override
	public void stopMonitoring() {
		super.stopMonitoring();
	}
	
}
