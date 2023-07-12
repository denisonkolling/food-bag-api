package com.example.foodbag.controller;

import com.example.foodbag.dto.ItemDto;
import com.example.foodbag.model.Bag;
import com.example.foodbag.model.Item;
import com.example.foodbag.service.BagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ifood/bag")
@RequiredArgsConstructor

public class BagController {

    private final BagService bagService;


    @PostMapping
    public Item addBagItem(@RequestBody ItemDto itemDto){
        return bagService.addBagItem(itemDto);
    }

    @GetMapping("/{id}")
    public Bag findBag(@PathVariable("id") Long id){
        return bagService.findBag(id);
    }

    @PatchMapping("/closeBag/{id}")
    public Bag closeBag(@PathVariable("id") Long id, @RequestParam("paymentMethod") Integer paymentMethod){
        return bagService.closeBag(id, paymentMethod);
    }
}
