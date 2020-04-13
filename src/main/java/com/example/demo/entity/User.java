package com.example.demo.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;


@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @Column(nullable = false)
    private String password;

    public User() {
    }

    public User(String name, String password) {

        this.name = name;

        this.password = password;
    }


    public void setName(String name) {

        this.name = name;

    }


    public void setPassword(String password) {

        this.password = password;

    }


    public String getName() {

        return name;

    }


    public long getId() {

        return id;

    }

}
