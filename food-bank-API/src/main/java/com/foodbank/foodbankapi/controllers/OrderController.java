package com.foodbank.foodbankapi.controllers;

import com.foodbank.foodbankapi.models.OrderModel;
import com.foodbank.foodbankapi.models.OrderState;
import com.foodbank.foodbankapi.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(value = "/orders")
    public OrderModel saveOrder(@RequestBody OrderModel orderModel) {
        orderModel.setState(OrderState.CREATED);
        orderModel.setCreatedDate(LocalDateTime.now(ZoneOffset.UTC));

        for (var item : orderModel.getItems()){
            item.setOrderModel(orderModel);
            item.setCreatedDate(LocalDateTime.now(ZoneOffset.UTC));
        }

        return  orderService.save(orderModel);
    }

    @GetMapping(value = "/orders")
    public Page<OrderModel> getOrders(@PageableDefault @SortDefault.SortDefaults({ @SortDefault(sort = "createdDate", direction = Sort.Direction.DESC)}) Pageable pageable) {
        return  orderService.findAll(pageable);
    }

    @GetMapping(value = "/orders/{id}")
    public Optional<OrderModel> getOrderById(@PathVariable long id) {
        return orderService.findById(id);
    }

    @DeleteMapping(value = "/orders/{id}")
    public void deleteOrderById(@PathVariable long id) {
        orderService.delete(id);
    }

    @PutMapping(value = "/orders/{id}")
    public OrderModel updateOrder(@PathVariable long id, @RequestBody OrderModel orderModel) {

        return orderService.update(id, orderModel);
    }
}