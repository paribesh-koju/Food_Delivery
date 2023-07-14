package com.example.annna_bazar;

import com.example.annna_bazar.entity.User;
import com.example.annna_bazar.repo.UserRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserTesting {
    @Autowired
    private UserRepo userRepo;
    @Test

    @Order(1)

    @Rollback(value = false)

    public void saveEmployeeTest(){

        User employee = User.builder()

                .fullName("Ramesh")

                .password("Fadatare")

                .email("ramesh@gmail.com")
                .mobileNo("87654")

                .build();



        userRepo.save(employee);



        Assertions.assertThat(employee.getId()).isGreaterThan(0);

    }
}
