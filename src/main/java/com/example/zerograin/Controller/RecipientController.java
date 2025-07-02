package com.example.zerograin.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.zerograin.Models.Donor;
import com.example.zerograin.Models.Recipient;
import com.example.zerograin.Services.RecipientService;

@Controller
public class RecipientController {
    @Autowired
    private RecipientService rs;

    @GetMapping("/join_ngo")
    public String Signup(Model model) {
        Donor d = new Donor();
        Recipient n= new Recipient();
        model.addAttribute("donordata", d);
        model.addAttribute("ngodata", n);
        return "NgoSignup";
    }

    @PostMapping("/savengo")
    public String save(@ModelAttribute("ngodata") Recipient r) {
        rs.saveRecipient(r);
        return "login";
    }


    @PostMapping("/ngo/login")
    public String LoginData(@ModelAttribute("ngologin") Recipient l, Model model) {

        boolean isAuthenticated = rs.findByEmail_password(l.getEmail(), l.getPassword());
        if (!isAuthenticated) {
            model.addAttribute("loginError", "Invalid email or password!");
            return "login"; // Return the login view
        }
        return "Ngodashboard";
    }
}
