package com.example.annna_bazar.controller;

import com.example.annna_bazar.pojo.AdminPagePojo;
import com.example.annna_bazar.pojo.HomePojo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/th-admin")
@RequiredArgsConstructor
public class ThymeLeafAdminPageController {
    @GetMapping("/create")
    public String getFormPage(Model model){
        model.addAttribute("admin", new AdminPagePojo());
        return "adminpage/mainpage.html";
    }
}
