package com.example.annna_bazar.services.impl;

import com.example.annna_bazar.entity.AdminPage;
import com.example.annna_bazar.entity.Order;
import com.example.annna_bazar.entity.User;
import com.example.annna_bazar.pojo.OrderPojo;
import com.example.annna_bazar.repo.OrderRepo;
import com.example.annna_bazar.services.AdminPageService;
import com.example.annna_bazar.services.OrderService;
import com.example.annna_bazar.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepo orderRepo;
    private final UserService userService;
    private final AdminPageService adminPageService;

    @Override
    public void saveData(OrderPojo orderPojo) throws IOException {
        Order order = new Order();

        User user = userService.fetchById(orderPojo.getUser_id()).get();
        AdminPage adminPage = adminPageService.fetchById(orderPojo.getAdminPage_id()).get();
        order.setAdminPage(adminPage);
        order.setUser(user);

        orderRepo.save(order);

    }

    @Override
    public List<Object> getOrderList(Integer user_id) {
        return orderRepo.getOrderListByUser(user_id);
    }

    @Override
    public Optional<Order> fetchAll(Integer id) {
        return orderRepo.findById(id);
    }


}
