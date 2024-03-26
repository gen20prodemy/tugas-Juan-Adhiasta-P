package com.prosigmaka.springWeb.controller;

import com.prosigmaka.springWeb.model.ProductModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
@RequestMapping("")
public class WebController {

    @GetMapping
    public String product(Model model){
        model.addAttribute("example","Table of Product");
        model.addAttribute("product", Arrays.asList(
                new ProductModel("Buku", 20000, 100),
                new ProductModel("Lego",50000,75),
                new ProductModel("Marjan",17000,300)
        ));
        return "index";
    }
}
