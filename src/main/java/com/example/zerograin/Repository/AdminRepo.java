package com.example.zerograin.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.zerograin.Models.Admin;

public interface AdminRepo extends JpaRepository<Admin,Integer>{
     @Query("select u from Admin u where username=:username AND password=:password AND security_code=:security_code")
    public Optional<Admin> findByName_Password_SecurityCode(@Param("username") String username, @Param("password") String password, @Param("security_code") String security_code);   
}

