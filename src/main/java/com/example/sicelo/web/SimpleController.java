package com.example.sicelo.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SimpleController {
    @Value("${spring.application.name}") String appName;

    @GetMapping("/")
    public String redirectToHomePage(Model model) {
        model.addAttribute("appName", appName);
        return "redirect:/home";
    }


    @GetMapping("/home")
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
        return "home";
    }

    @GetMapping("/rooms")
    public String getRooms(Model model){
        model.addAttribute("appName", appName);
        return "rooms";
    }

    @GetMapping("/book_now")
    public String getForm(Model model) {
        model.addAttribute("appName", appName);
        return "book_now";
    }

    @GetMapping("/about_us")
    public String getAboutUsPage(Model model){
        model.addAttribute("appName", appName);
        return "about_us";
    }

}


