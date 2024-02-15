package com.example.connection;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "User Management",
                description = "Spring Boot User Management Project",
                version = "v1-0",
                contact = @Contact(
                        name = "Sakib",
                        email = "sakibxhossain021@gmail.com",
                        url = "https://visualflow.com"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://visual.com/apache_licence"
                )
        ),externalDocs = @ExternalDocumentation(
                description = "More feature will be added!",
                url = "https://visual.com/future_docs"
)
)
public class MySqlConnectionApplication {

    //Annotated as a bean and configured Model mapper to use anywhere in this project
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(MySqlConnectionApplication.class, args);
    }

}
