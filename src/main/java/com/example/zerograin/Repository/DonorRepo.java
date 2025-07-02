package com.example.zerograin.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.zerograin.Models.Donor;

public interface DonorRepo extends JpaRepository<Donor, Integer> {
    @Query("select u from Donor u where email=:email AND password=:password ")
    public Optional<Donor> findByEmail_Password(@Param("email") String email, @Param("password") String password);
}
