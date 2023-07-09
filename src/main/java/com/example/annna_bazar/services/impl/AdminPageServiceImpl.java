package com.example.annna_bazar.services.impl;

import com.example.annna_bazar.entity.AdminPage;
import com.example.annna_bazar.pojo.AdminPagePojo;
import com.example.annna_bazar.repo.AdminPageRepo;
import com.example.annna_bazar.services.AdminPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminPageServiceImpl implements AdminPageService {
    private final AdminPageRepo adminPageRepo;

    @Override
    public void saveData(AdminPagePojo adminPagePojo){
        AdminPage adminPage = new AdminPage();
        adminPage.setId(adminPagePojo.getId());
        adminPage.setItem_name(adminPagePojo.getItem_name());
        adminPage.setItem_price(adminPagePojo.getItem_price());
        adminPage.setItem_rating(adminPagePojo.getItem_rating());
        adminPage.setItem_description(adminPagePojo.getItem_description());
        adminPageRepo.save(adminPage);
    }

    @Override
    public List<AdminPage> getData() {
        return adminPageRepo.findAll();
    }
    @Override
    public void deleteById(Integer id) {
        adminPageRepo.deleteById(id);
    }

    @Override
    public Optional<AdminPage> getById(Integer id) {
        return adminPageRepo.findById(id);
    }

    @Override
    public void dropById(Integer id) { adminPageRepo.deleteById(id);
    }

    @Override
    public List<AdminPage> getAllData() {
        return adminPageRepo.findAll();
    }

    @Override
    public Optional<AdminPage> fetchById(Integer id) {
        return adminPageRepo.findById(id);
    }

    @Override
    public AdminPage getByIdNotOpt(Integer id) {
        return adminPageRepo.findById(id).orElseThrow(()->new RuntimeException("not found"));
    }
}
