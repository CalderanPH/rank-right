package br.paulocalderan.rankright;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class RankRightApplication {

    public static void main(String[] args) {
        SpringApplication.run(RankRightApplication.class, args);
    }

}
