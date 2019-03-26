package com.myspace.microservices.limitsservices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myspace.microservices.limitsservices.bean.LimitsConfiguration;

@RestController
public class LimitsConfigurationController {
	
	@Autowired
	private Configuration configuration;

	@GetMapping("/limits")
	public LimitsConfiguration retrieveLimitsConfig() {
    return new LimitsConfiguration(configuration.getMaximum(), configuration.getMinimum());
	}
}
