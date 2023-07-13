package com.example.foodbag.controller;


import com.example.foodbag.model.Restaurant;
import com.example.foodbag.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ifood/restaurant")
@RequiredArgsConstructor

public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @GetMapping
    public List<Restaurant> getAllRestaurant(){
        return restaurantService.getAllRestaurant();
    }

}
