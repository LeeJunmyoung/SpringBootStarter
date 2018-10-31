package me.jun.web;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {




    public static void main(String[] args) {
        SpringApplication app =new SpringApplication(Application.class);
        //app.addListeners(new SampleListener());
        //app.setWebApplicationType(WebApplicationType.NONE);
        app.run(args);
    }
}
