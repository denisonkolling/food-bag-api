package com.example.foodbag.service;

import com.example.foodbag.model.Product;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {

    public List<Product> getAllProducts();

    public Product getProductById(Long id);
}
