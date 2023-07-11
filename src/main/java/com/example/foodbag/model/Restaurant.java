package com.example.foodbag.model;

import jakarta.persistence.*;

import java.util.List;

public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Product> foodMenu;

    @Embedded
    private Address adrress;


}
