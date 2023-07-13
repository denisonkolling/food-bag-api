package com.example.foodbag.service.impl;

import com.example.foodbag.dto.ItemDto;
import com.example.foodbag.enumeration.PaymentMethod;
import com.example.foodbag.model.Bag;
import com.example.foodbag.model.Item;
import com.example.foodbag.model.Restaurant;
import com.example.foodbag.repository.BagRepository;
import com.example.foodbag.repository.ItemRepository;
import com.example.foodbag.repository.ProductRepository;
import com.example.foodbag.service.BagService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor

@Service
public class BagServiceImpl implements BagService{

    @Autowired
    private final BagRepository bagRepository;

    @Autowired
    private final ProductRepository productRepository;

    @Autowired
    private final ItemRepository itemRepository;


    @Override
    public Item addBagItem(ItemDto itemDto) {
        Bag bag = findBag(itemDto.getBagId());

        if (bag.isClosed()) {
            throw new RuntimeException("This bag is already closed");
        }

        Item newItem = Item.builder()
                .quantity(itemDto.getQuantity())
                .bag(bag)
                .product(productRepository.findById(itemDto.getProductId()).orElseThrow(() -> {
                    throw new RuntimeException("Product doesn't exist");
                }))
                .build();

        List<Item> bagItems = bag.getItems();

        if(bagItems.isEmpty()){
            bagItems.add(newItem);
        } else {
            Restaurant presentRestaurant = bagItems.get(0).getProduct().getRestaurant();
            Restaurant newRestaurant = newItem.getProduct().getRestaurant();
            if (presentRestaurant.equals(newRestaurant)){
                bagItems.add(newItem);
            } else {
                throw new RuntimeException("Not possible to add product from different restaurants");
            }
        }

        List<Double> itemsValue = new ArrayList<>();

        for (Item bagItem: bagItems){
            double  itemTotalValue = bagItem.getProduct().getUnitValue() * bagItem.getQuantity();
            itemsValue.add(itemTotalValue);
        }

        double totalBagValue = itemsValue.stream()
                .mapToDouble(itemTotalUnitValue -> itemTotalUnitValue )
                .sum();


        bag.setBagTotalValue(totalBagValue);
        bagRepository.save(bag);
        return itemRepository.save(newItem);
    }

    @Override
    public Bag findBag(Long id) {
        return bagRepository.findById(id).orElseThrow(
                () -> {throw new RuntimeException("This bag doesn't exist");
                }
        );
    }


    @Override
    public Bag closeBag(Long id, Integer numPaymentMethod) {
        Bag bag = findBag(id);

        if(bag.getItems().isEmpty()) {
            throw new RuntimeException("The bag is empty");
        }

        PaymentMethod paymentMethod = numPaymentMethod == 0 ? PaymentMethod.CARD : PaymentMethod.CASH;

        bag.setPaymentMethod(paymentMethod);
        bag.setClosed(true);
        return null;
    }
}
