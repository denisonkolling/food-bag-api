package com.example.foodbag.service.impl;

import com.example.foodbag.model.Product;
import com.example.foodbag.model.Restaurant;
import com.example.foodbag.repository.ProductRepository;
import com.example.foodbag.repository.RestaurantRepository;
import com.example.foodbag.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor

@Service

public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    RestaurantRepository restaurantRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product createProduct(Product form) {
        Product product = new Product();
        Restaurant restaurant = restaurantRepository.findById(form.getRestaurant().getId()).orElse(null);

        if (restaurant == null) {
            throw new RuntimeException();
        } else {
            // O restaurante foi encontrado com sucesso
            product.setRestaurant(restaurant);
            product.setName(form.getName());
            product.setUnitValue(form.getUnitValue());

            return productRepository.save(product);
        }
    }

}

//    @Override
//    public Invoice createInvoice(Invoice form) {
//        Invoice invoice = new Invoice();
//        Customer issuer = customerRepository.findById(form.getIssuer().getId()).get();
//        Customer buyer = customerRepository.findById(form.getBuyer().getId()).get();
//        Item item = itemRepository.findById(form.getItem().getId()).get();
//
//        invoice.setNumber(form.getNumber());
//        invoice.setDate(form.getDate());
//        invoice.setIssuer(issuer);
//        invoice.setBuyer(buyer);
//        invoice.setItem(item);
//
//        return invoiceRepository.save(invoice);
//
//    }


