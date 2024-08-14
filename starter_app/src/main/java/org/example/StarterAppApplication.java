package org.example;

import org.example.config.InfraConfig;
import org.example.config.RestAppInitializer;
import org.example.config.RestConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Collections;

@SpringBootApplication
public class StarterAppApplication {

    public static void main(String[] args) {
        //Démarrer l'application infrastructure (Spring data)
        SpringApplication infra = new SpringApplication(InfraConfig.class);
        infra.setDefaultProperties(Collections.singletonMap("server.port", "8081"));
        ConfigurableApplicationContext infraContext =  infra.run();


        //Démarrer l'application adapter rest (spring web)
        //Ajouter dans le container de dependances les services et repositories du domain de l'infrastructure
        SpringApplication rest = new SpringApplication(RestConfig.class);
        rest.setDefaultProperties(Collections.singletonMap("server.port", "8082"));
        rest.addInitializers(new RestAppInitializer(infraContext));
        ConfigurableApplicationContext restContext =  rest.run();


    }

}
