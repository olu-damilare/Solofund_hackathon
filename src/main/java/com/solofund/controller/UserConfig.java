package com.solofund.controller;

import com.solofund.models.User;
import com.solofund.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository){
        return args -> {
            User olu = new User(
                    "123456789",
                    "John",
                    "Doe"
            );



            repository.saveAll(
                    List.of(olu)
            );

        };
    }
}
