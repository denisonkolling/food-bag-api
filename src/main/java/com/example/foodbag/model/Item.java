package com.example.foodbag.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Product product;

    private Integer quantity;

    @ManyToOne
    @JsonIgnore
    private Bag bag;

}
