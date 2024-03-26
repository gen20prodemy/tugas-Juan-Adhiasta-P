package com.prosigmaka.springWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; //container untuk menghubungkan controller dengan template
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class WebController {

    @GetMapping
    public String welcome(Model model){ //yang di return halaman HTML
        String message = "Welcome to Spring MVC using model";
        model.addAttribute("message",message);
        return "index"; //tanda kutip untuk return tipe string
    }
}
