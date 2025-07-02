package com.example.zerograin.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.zerograin.Models.Admin;
import com.example.zerograin.Models.Donated_food;
import com.example.zerograin.Repository.AdminRepo;
import com.example.zerograin.Repository.Donated_foodRepo;

@Service
public class AdminService {

    @Autowired
    private AdminRepo ar;

    public boolean findByName_Password_SecurityCode(String name, String password ,String security_code ) {
        Optional<Admin> s = ar.findByName_Password_SecurityCode(name, password ,security_code);
        return s.isPresent();
    }
    
    @Autowired
    private Donated_foodRepo dfr;

    public void foodSave(Donated_food df)
    {
        dfr.save(df);
    }
    public List<Donated_food> Find() {
        return dfr.findAll();

    }
}
