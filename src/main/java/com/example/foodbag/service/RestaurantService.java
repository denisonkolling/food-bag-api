package com.example.foodbag.service;

import com.example.foodbag.model.Restaurant;


import java.util.List;


public interface RestaurantService {

public Restaurant createRestaurant(Restaurant restaurant);

public List<Restaurant> getAllRestaurant();

public Restaurant getRestaurantById(Long id);

public String deleteRestaurant(Long id);

public Restaurant editRestaurant(Restaurant restaurant, Long id);

}


//TODO public Food createFood(Food food);

//TODO public List<Food> getAllFood();

//TODO public Food getFoodById(Long id);

//TODO public String deleteFood(Long id);

//TODO public Food editFood(Food food, Long id);