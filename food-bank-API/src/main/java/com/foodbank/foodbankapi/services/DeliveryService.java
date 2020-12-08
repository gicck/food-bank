package com.foodbank.foodbankapi.services;

import com.foodbank.foodbankapi.models.DeliveryModel;
import com.foodbank.foodbankapi.models.OrderModel;
import com.foodbank.foodbankapi.repositories.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;

    public DeliveryModel save(DeliveryModel deliveryModel) {
        return  deliveryRepository.save(deliveryModel);
    }

    public Page<DeliveryModel> findAll(Pageable pageable) {
        return deliveryRepository.findAll(pageable);
    }
}
