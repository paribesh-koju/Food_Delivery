package com.example.annna_bazar.controller;

import com.example.annna_bazar.entity.AdminPage;
import com.example.annna_bazar.pojo.AdminPagePojo;
import com.example.annna_bazar.pojo.HomePojo;
import com.example.annna_bazar.services.AdminPageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/th-admin")
@RequiredArgsConstructor
public class ThymeLeafAdminPageController {

    private final AdminPageService adminPageService;
    @GetMapping("/create")
    public String getFormPage(Model model){
        model.addAttribute("admin", new AdminPagePojo());
        return "adminpage/mainpage.html";
    }

    @PostMapping("save")
    public String saveData(@Valid AdminPagePojo adminPagePojo) {
        adminPageService.saveData(adminPagePojo);
        return "redirect:/th-department/table";
    }
    @GetMapping("edit/{id}")
    public String getUpdateData(@PathVariable Integer id, Model model){
        AdminPage adminPage =adminPageService.getByIdNotOpt(id);
        model.addAttribute("departmentDto",new AdminPagePojo(adminPage));
        return "department/create.html";
    }
    @GetMapping("delete/{id}")
    public String getDeleteData(@PathVariable Integer id){
        adminPageService.deleteById(id);
        return "redirect:/th-department/table";
    }
}
