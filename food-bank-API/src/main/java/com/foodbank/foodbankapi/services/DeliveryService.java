package com.foodbank.foodbankapi.services;

import com.foodbank.foodbankapi.models.DeliveryModel;
import com.foodbank.foodbankapi.repositories.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;

    public DeliveryModel save(DeliveryModel deliveryModel) {
        return  deliveryRepository.save(deliveryModel);
    }
}
