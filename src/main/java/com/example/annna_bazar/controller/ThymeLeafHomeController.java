package com.example.annna_bazar.controller;


import com.example.annna_bazar.entity.AdminPage;
import com.example.annna_bazar.pojo.HomePojo;
import com.example.annna_bazar.services.AdminPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

@Controller
@RequestMapping("th-home")
@RequiredArgsConstructor
public class ThymeLeafHomeController {
    private final AdminPageService adminPageService;
    @GetMapping("create")
    public String getFormPage(Model model){
        model.addAttribute("home", new HomePojo());
        model.addAttribute("items",adminPageService.getAllData().stream().map(res->
                AdminPage.builder()
                        .id(res.getId())
                        .imageBase64(getImageBase64(res.getImage()))
                        .item_description(res.getItem_description())
                        .item_name(res.getItem_name())
                        .item_price(res.getItem_price())
                        .item_rating(res.getItem_rating())
                        .build()));
        return "homepage/home";
    }

    public String getImageBase64(String fileName) {
        String filePath = System.getProperty("user.dir") + "/file_server/";
        File file = new File(filePath + fileName);
        byte[] bytes = new byte[0];
        try {
            bytes = Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        String base64 = Base64.getEncoder().encodeToString(bytes);
        return base64;
    }
}
