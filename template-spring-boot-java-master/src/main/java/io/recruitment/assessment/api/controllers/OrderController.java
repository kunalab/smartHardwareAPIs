package io.recruitment.assessment.api.controllers;

import io.recruitment.assessment.api.Repo.OrderRepo;
import io.recruitment.assessment.api.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderRepo repo;
    @GetMapping(path = "/getAllOrders/{userId}")
    public Optional<Order> getOrders(@PathVariable("userId")  int userId)
    {
        return repo.findOrderByUserID(userId);
    }

}
