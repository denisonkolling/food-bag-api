package com.example.foodbag.repository;

import com.example.foodbag.model.Bag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BagRepository extends JpaRepository <Bag, Long> {
}
