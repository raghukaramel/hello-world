package com.walmart;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@GetMapping(path="/", produces="text/plain")
	public String hello() {
		return "Hello!";
	}
	
	@GetMapping(path="/healthz", produces="application/json")
	public HashMap<String, String> health() {
				
		RuntimeMXBean rb = ManagementFactory.getRuntimeMXBean();		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date startDate = new Date(System.currentTimeMillis() - rb.getUptime());
		
		HashMap<String, String> result = new HashMap<String, String>();
		result.put("status", "OK");
		result.put("version", "0.0.1");
		result.put("uptime", "up since " + sdf.format(startDate))	;
		return result;
		
	}

}
