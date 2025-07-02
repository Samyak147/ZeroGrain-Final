package com.example.zerograin.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.zerograin.Models.Donor;
import com.example.zerograin.Models.Recipient;
import com.example.zerograin.Services.DonorService;

@Controller
// @RequestMapping("/user")
public class DonorController {
    @Autowired
    private DonorService ds;

    @GetMapping("/join_donor")
    public String Signup(Model model) {
        Donor d = new Donor();
        Recipient n = new Recipient();
        model.addAttribute("donordata", d);
        model.addAttribute("ngodata", n);
        return "donorSignup";
    }

    @PostMapping("/savedonor")
    public String save(@ModelAttribute("donordata") Donor d) {
        ds.SaveDonor(d);
        return "login";
    }

    @PostMapping("/donor/login")
    public String LoginData(@ModelAttribute("ngologin") Donor l, Model model) {

        boolean isAuthenticated = ds.findByEmail_Password(l.getEmail(), l.getPassword());
        if (!isAuthenticated) {
            model.addAttribute("loginError", "Invalid email or password!");
            return "login"; // Return the login view
        }
        return "Donordashboard";
    }

}
