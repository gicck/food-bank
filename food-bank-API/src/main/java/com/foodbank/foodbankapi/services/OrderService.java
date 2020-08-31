package com.foodbank.foodbankapi.services;

import com.foodbank.foodbankapi.models.OrderModel;
import com.foodbank.foodbankapi.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public OrderModel save(OrderModel orderModel) {
        return  orderRepository.save(orderModel);
    }

    public OrderModel update(long id, OrderModel newOrder) {
        orderRepository.findById(id).map(order -> {
            order.setEmployeeName(newOrder.getEmployeeName());
            order.setEntityName(newOrder.getEntityName());
            order.setEntityEmployeeName(newOrder.getEntityEmployeeName());
            order.setState(newOrder.getState());
            switch (newOrder.getState()) {
                case ACCEPTED:
                    order.setAcceptedDate(LocalDateTime.now(ZoneOffset.UTC));
                    break;
                case PACKED:
                    order.setPackedDate(LocalDateTime.now(ZoneOffset.UTC));
                    break;
                case RECEIVED:
                    order.setReceivedDate(LocalDateTime.now(ZoneOffset.UTC));
                    break;
                case FINALIZED:
                    order.setFinalizedDate(LocalDateTime.now(ZoneOffset.UTC));
                    break;
                case DISPATCHED:
                    order.setDispatchedDate(LocalDateTime.now(ZoneOffset.UTC));
                    break;
            }
            return orderRepository.save(order);
        })
        .orElseGet(() -> {
            newOrder.setId(id);
            return orderRepository.save(newOrder);
        });
        return  newOrder;
    }

    public void softDelete(long id) {
        orderRepository.findById(id).map(order -> {
            order.setDeletedDate(LocalDateTime.now(ZoneOffset.UTC));
            order.setDeleted(true);
            return orderRepository.save(order);
        });
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
