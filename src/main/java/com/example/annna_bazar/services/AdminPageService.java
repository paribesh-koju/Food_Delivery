package com.example.annna_bazar.services;

import com.example.annna_bazar.entity.AdminPage;
import com.example.annna_bazar.pojo.AdminPagePojo;

import java.util.List;
import java.util.Optional;

public interface AdminPageService {
    void saveData (AdminPagePojo adminPagePojo);

    List<AdminPage> getData();

    void deleteById(Integer id);

    Optional<AdminPage> getById(Integer id);

    void dropById(Integer id);

    List<AdminPage> getAllData();

    Optional<AdminPage> fetchById(Integer id);

    AdminPage getByIdNotOpt(Integer id);
}
