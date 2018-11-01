package me.jun.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {




    public static void main(String[] args) {
        SpringApplication app =new SpringApplication(Application.class);
        //app.addListeners(new SampleListener());
        //app.setWebApplicationType(WebApplicationType.NONE);
        app.run(args);
    }



}
