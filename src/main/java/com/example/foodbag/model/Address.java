package com.example.foodbag.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@Embeddable
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Address {
    private String zipcode;
    private String street;
    private String city;
}
