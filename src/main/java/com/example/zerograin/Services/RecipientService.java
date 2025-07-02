package com.example.zerograin.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.zerograin.Models.Recipient;
import com.example.zerograin.Repository.RecipientRepo;

@Service
public class RecipientService {
    @Autowired
    private RecipientRepo rr;

    public void saveRecipient(Recipient r) {
        rr.save(r);
    }

    public boolean findByEmail_password(String email, String password)
    {
        Optional<Recipient> r=rr.findByEmail_Password(email,password);
        return r.isPresent();
    }
   
}
