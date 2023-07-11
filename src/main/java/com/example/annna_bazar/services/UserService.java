package com.example.annna_bazar.services;

import com.example.annna_bazar.entity.User;
import com.example.annna_bazar.pojo.LoginPojo;
import com.example.annna_bazar.pojo.UserPojo;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;



public interface UserService {
    UserPojo save(UserPojo userPojo) throws IOException;

    List<User> fetchAll();

    User fetchById(Integer id);

    void deleteById(Integer id);

    void sendEmail();

    User fatchByEmail(String email);
}
