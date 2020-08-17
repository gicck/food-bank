package com.foodbank.foodbankapi.services;

import com.foodbank.foodbankapi.models.OrderModel;
import com.foodbank.foodbankapi.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public OrderModel save(OrderModel orderModel) {
        return  orderRepository.save(orderModel);
    }

    public OrderModel update(long id, OrderModel orderModel) {
        orderModel.setId(id);
        return  orderRepository.save(orderModel);
    }

    public void delete(long id) {
        orderRepository.deleteById(id);
    }

    public Page<OrderModel> findAll(Pageable pageable) {
        return  orderRepository.findAll(pageable);
    }

    public Optional<OrderModel> findById(long orderId){
        return  orderRepository.findById(orderId);
    }
}
