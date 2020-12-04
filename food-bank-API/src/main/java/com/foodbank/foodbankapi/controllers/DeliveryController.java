package com.foodbank.foodbankapi.controllers;

import com.foodbank.foodbankapi.models.DeliveryModel;
import com.foodbank.foodbankapi.services.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @PostMapping(value = "/deliveries")
    public DeliveryModel saveDelivery(@RequestBody DeliveryModel deliveryModel) {
        return  deliveryService.save(deliveryModel);
    }


}
