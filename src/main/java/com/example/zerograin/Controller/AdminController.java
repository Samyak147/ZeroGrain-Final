package com.example.zerograin.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.zerograin.Models.Admin;
import com.example.zerograin.Models.Donated_food;
import com.example.zerograin.Models.Donor;
import com.example.zerograin.Models.Recipient;
import com.example.zerograin.Services.AdminService;

@Controller
public class AdminController {
    @Autowired
    private AdminService as;
    // private Donated_foodService dfs;

    @GetMapping("/")
    public String Home()
    {
        return "index";
    }


    @GetMapping("/login")
    public String Login(Model model)
    {
        Donor d = new Donor();
        Recipient n= new Recipient();
        Admin a = new Admin();    
        model.addAttribute("donorlogin", d);
        model.addAttribute("ngologin", n);
        model.addAttribute("adminlogin", a); 
        return "login";

    }
    
    @PostMapping("/admin/login")
    public String LoginData(@ModelAttribute("adminlogin") Admin l , Model model) {

        boolean isAuthenticated = as.findByName_Password_SecurityCode(l.getUsername(), l.getPassword(),l.getSecurity_code());
        if (!isAuthenticated) {
            model.addAttribute("loginError", "Invalid email or password!");
            return "login"; // Return the login view
        }
        model.addAttribute("recentDonations", as.Find());
        return "AdminPanel";
    }
    
    

    // Food Donation control
    @GetMapping("/donor/donate")
    public String Food_Donation_Details(Model model)
    {
        Donated_food df =new Donated_food();
        model.addAttribute("donatedfood", df);
        return "Donatefood";
    }

    @PostMapping("/donated_food")
    public String FoodSave(@ModelAttribute("donatedfood") Donated_food df )
    {
        as.foodSave(df);
        return "Donordashboard";
    }


    
}    
    
