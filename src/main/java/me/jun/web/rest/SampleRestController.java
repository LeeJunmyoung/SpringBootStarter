package me.jun.web.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleRestController {

	@GetMapping("/rest/rest")
	public String restTemplateTest() throws InterruptedException{
		
		Thread.sleep(5000);
		
		return "rest hello";
	}
	
	@GetMapping("/rest/web")
	public String webClientTest() throws InterruptedException {
		
		Thread.sleep(2000);
		
		return "web hello";
	}
	
}
