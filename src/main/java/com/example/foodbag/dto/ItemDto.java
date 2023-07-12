package com.example.foodbag.dto;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@Embeddable
@NoArgsConstructor


public class ItemDto {

    private Long productId;

    private Integer quantity;

    private Long bagId;


}
