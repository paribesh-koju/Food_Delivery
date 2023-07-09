package com.example.annna_bazar.services.impl;

import com.example.annna_bazar.config.PasswordEncoderUtil;
import com.example.annna_bazar.entity.User;
import com.example.annna_bazar.pojo.UserPojo;
import com.example.annna_bazar.repo.UserRepo;
import com.example.annna_bazar.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    @Override
    public UserPojo save(UserPojo userPojo) throws IOException {
        User user= new User();
        user.setId(userPojo.getId());
        user.setEmail(userPojo.getEmail());
        user.setFullName(userPojo.getFullname());
        user.setMobileNo(userPojo.getMobile_no());
        user.setPassword(PasswordEncoderUtil.getInstance().encode(userPojo.getPassword()));

       user= userRepo.save(user);
        return new UserPojo(user);
    }

    @Override
    public List<User> fetchAll() {
        return null;
    }

    @Override
    public User fetchById(Integer id) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void sendEmail() {

    }
}
