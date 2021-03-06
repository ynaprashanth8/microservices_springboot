package com.myspace.microservices.currencyexchangeservice;

import java.math.BigDecimal;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private Environment environment;
	
	private org.slf4j.Logger logging = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ExchangeValueRepository exchangeRepo;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	 public ExchangeValue retrievExcahngeValue(@PathVariable String from, @PathVariable String to ) {
		ExchangeValue exValue =  exchangeRepo.findByFromAndTo(from, to);
		
		logging.info("######### ExchangeValue #############: "+ exValue);
		exValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return exValue;
	 }
}
