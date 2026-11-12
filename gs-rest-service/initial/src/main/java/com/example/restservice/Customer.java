package com.example.restservice;

public class Customer {
    private String id;
    private String customer;
    private String name;
    private String status;


    // Constructor
    public Customer(String id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

}