package com.example.foodbag.service.impl;

import com.example.foodbag.model.Restaurant;
import com.example.foodbag.repository.RestaurantRepository;
import com.example.foodbag.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {


    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public Restaurant createRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public List<Restaurant> getAllRestaurant() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant getRestaurantById(Long id) {
        return restaurantRepository.findById(id).get();
    }

    @Override
    public String deleteRestaurant(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id).get();

        if (restaurant != null) {
            restaurantRepository.delete(restaurant);
            return "Restaurant deleted successfully";
        }
        return "Something wron on server";
    }

    @Override
    public Restaurant editRestaurant(Restaurant restaurant, Long id) {
        Restaurant oldRestaurant = restaurantRepository.findById(id).get();
        oldRestaurant.setName(restaurant.getName());

        return restaurantRepository.save(oldRestaurant);

        //TODO Implementar metodo completo editar restaurante que manipule objeto endereco
    }
}



