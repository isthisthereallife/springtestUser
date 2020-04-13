package com.example.demo.factory;

import com.example.demo.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserServiceFactory {

    @Bean("createService")
    public UserService createService(){
        return new UserService("super duper secret password");
    }

}