package com.example.annna_bazar.services.impl;

import com.example.annna_bazar.config.PasswordEncoderUtil;
import com.example.annna_bazar.entity.User;
import com.example.annna_bazar.pojo.UserPojo;
import com.example.annna_bazar.repo.UserRepo;
import com.example.annna_bazar.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

//    private final String UPLOAD_DIRECTORY=System.getProperty("user.dir")+"/photo_file";
    @Override
    public UserPojo save(UserPojo userPojo) throws IOException {
        User user= new User();
        user.setId(userPojo.getId());
        user.setEmail(userPojo.getEmail());
        user.setFullName(userPojo.getFullname());
        user.setMobileNo(userPojo.getMobile_no());
        user.setPassword(PasswordEncoderUtil.getInstance().encode(userPojo.getPassword()));

//        if(userPojo.getImage()!=null){
//            StringBuilder fileNames = new StringBuilder();
//            System.out.println(UPLOAD_DIRECTORY);
//            Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, userPojo.getImage().getOriginalFilename());
//            fileNames.append(userPojo.getImage().getOriginalFilename());
//            Files.write(fileNameAndPath, userPojo.getImage().getBytes());
//
//            user.setImage(userPojo.getImage().getOriginalFilename());
//        }

       user= userRepo.save(user);
        return new UserPojo(user);
    }

    @Override
    public List<User> fetchAll() {
        return userRepo.findAll();
    }

    @Override
    public User fetchById(Integer id) {
        return userRepo.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
    }

    @Override
    public void deleteById(Integer id) {
        userRepo.deleteById(id);
    }

    @Override
    public void sendEmail() {

    }

    @Override
    public User fatchByEmail(String email) {
        return userRepo.findByEmail(email).orElseThrow(() -> new RuntimeException("Not Found"));
    }
}
