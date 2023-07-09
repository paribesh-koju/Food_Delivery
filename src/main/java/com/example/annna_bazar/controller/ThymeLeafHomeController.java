package com.example.annna_bazar.controller;


import com.example.annna_bazar.pojo.HomePojo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("th-home")
@RequiredArgsConstructor
public class ThymeLeafHomeController {
    @GetMapping("create")
    public String getFormPage(Model model){
        model.addAttribute("home", new HomePojo());
        return "homepage/home";
    }
}
