package com.example.stockalert.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/products-page")
    public String productsPage() {
        return "products";
    }

    @GetMapping("/movements-page")
    public String movementsPage() {
        return "movements";
    }
}