package com.example.zerograin.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.zerograin.Models.Donated_food;

public interface Donated_foodRepo extends JpaRepository <Donated_food,Integer> {
    
}
