package me.jun.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Component
public class RestRunner implements ApplicationRunner{

	@Autowired
	RestTemplateBuilder restTemplateBuilder;
	
	@Autowired
	WebClient.Builder builder;
	
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		{
			RestTemplate restTemplate = restTemplateBuilder.build();
		
		
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		String respRest = restTemplate.getForObject("http://localhost:30000/rest/rest", String.class);
		System.out.println(respRest);
		
		String respWeb = restTemplate.getForObject("http://localhost:30000/rest/web", String.class);
		System.out.println(respWeb);
		
		stopWatch.stop();
		System.out.println(stopWatch.prettyPrint());
		}
		
		
		
		
		{
		WebClient webClient = builder
									//.baseUrl("http://localhost:30000")
									.build();
		

		StopWatch stopWatch = new StopWatch();
		StopWatch stopWatch1 = new StopWatch();
		StopWatch stopWatch2 = new StopWatch();
		stopWatch.start();
		stopWatch1.start();
		stopWatch2.start();
		Mono<String> respRest = webClient.get().uri("/rest/rest") 
								    .retrieve()
								    .bodyToMono(String.class);
		respRest.subscribe(s->{
			System.out.println(s);
			
			if(stopWatch1.isRunning()){
				stopWatch1.stop();
			}
			System.out.println(stopWatch1.prettyPrint());
			
		});		
		
		
		Mono<String> respWeb = webClient.get().uri("/rest/web") 
			    .retrieve()
			    .bodyToMono(String.class);
		
		respWeb.subscribe(s->{
			System.out.println(s);
			
			if(stopWatch2.isRunning()){
				stopWatch2.stop();
			}
			System.out.println(stopWatch2.prettyPrint());
			
		});
		
		
		stopWatch.stop();
		System.out.println(stopWatch.prettyPrint());
		}
		
	}

}
