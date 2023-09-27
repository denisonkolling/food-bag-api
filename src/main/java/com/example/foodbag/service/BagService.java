package com.example.foodbag.service;

import com.example.foodbag.dto.ItemDto;
import com.example.foodbag.model.Bag;
import com.example.foodbag.model.Item;



public interface BagService {

    Item addBagItem(ItemDto itemDto);

    Bag findBag(Long id);

    Bag closeBag(Long id, Integer paymentMethod);

}
