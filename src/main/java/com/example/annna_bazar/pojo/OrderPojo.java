package com.example.annna_bazar.pojo;

import com.example.annna_bazar.entity.AdminPage;
import com.example.annna_bazar.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderPojo {
    private Integer id;
    private Integer user_id;
    private Integer adminPage_id;
}
