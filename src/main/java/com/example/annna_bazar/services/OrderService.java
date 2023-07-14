package com.example.annna_bazar.services;

import com.example.annna_bazar.entity.AdminPage;
import com.example.annna_bazar.entity.Order;
import com.example.annna_bazar.entity.User;
import com.example.annna_bazar.pojo.OrderListPojo;
import com.example.annna_bazar.pojo.OrderPojo;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface OrderService {
    void saveData(OrderPojo orderPojo) throws IOException;

    List<Object> getOrderList(Integer user_id);

    Optional<Order> fetchAll(Integer id);
}
