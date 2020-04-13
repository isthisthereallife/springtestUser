package com.example.demo.service;

import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService() {
    }

    public UserService(String password) {
        this.pw = password;
    }

    private String pw = "hehe";

    public String getDatabasePassword() {
        return pw;
    }
    public void setDatabasePassword(String pw) {
        this.pw = pw;
    }

}
