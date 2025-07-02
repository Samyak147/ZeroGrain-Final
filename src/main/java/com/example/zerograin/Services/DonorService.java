package com.example.zerograin.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.zerograin.Models.Donor;
import com.example.zerograin.Repository.DonorRepo;

@Service
public class DonorService {
    @Autowired
    private DonorRepo dr;

    public void SaveDonor(Donor d) {
        dr.save(d);
    }

    public boolean findByEmail_Password(String email, String password)
   {
        Optional<Donor> d=dr.findByEmail_Password(email,password);
        return d.isPresent();
   }

   
}