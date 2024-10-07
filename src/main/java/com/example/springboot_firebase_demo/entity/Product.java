package com.example.springboot_firebase_demo.entity;

public class Product {

    private String name;
    private String description;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
