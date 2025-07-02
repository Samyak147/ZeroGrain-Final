package com.example.zerograin.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.zerograin.Models.Recipient;

public interface RecipientRepo extends JpaRepository<Recipient, Integer> {
    @Query("select u from Recipient u where email=:email AND password=:password ")
    public Optional<Recipient> findByEmail_Password(@Param("email") String email, @Param("password") String password);
}
