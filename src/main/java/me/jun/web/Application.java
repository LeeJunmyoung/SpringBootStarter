package me.jun.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.boot.web.reactive.function.client.WebClientCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient.Builder;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@EnableAdminServer
public class Application {




    public static void main(String[] args) {
        SpringApplication app =new SpringApplication(Application.class);
        //app.addListeners(new SampleListener());
        //app.setWebApplicationType(WebApplicationType.NONE);
        app.run(args);
    }
    
    @Bean
    public WebClientCustomizer webClientCustomizer(){
    	return new WebClientCustomizer() {
			
			@Override
			public void customize(Builder webClientBuilder) {
				// TODO Auto-generated method stub
				webClientBuilder.baseUrl("http://localhost:30000");
			}
		};
    	
    }

    @Bean
    public RestTemplateCustomizer restTemplateCustomizer(){
    	return ((restTemplate) -> {
				restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
		});
    		
    	
    }


}
