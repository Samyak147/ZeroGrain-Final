package com.example.zerograin.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "food_details")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Donated_food {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    int id;
    String foodname;
    String f_type;
    String f_category;
    String quantity;
    String email;
    String phone;
    String area;
    String address;

}
