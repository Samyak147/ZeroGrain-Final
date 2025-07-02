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
@Table(name = "zerograin_donor")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Donor {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    int id;
    String name;
    String password;
    String phone;
    String email;
    String address;
}
