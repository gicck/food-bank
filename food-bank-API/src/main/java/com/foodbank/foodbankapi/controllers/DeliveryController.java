package com.foodbank.foodbankapi.controllers;

import com.foodbank.foodbankapi.models.DeliveryModel;
import com.foodbank.foodbankapi.services.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @PostMapping(value = "/deliveries")
    public DeliveryModel saveDelivery(@RequestBody DeliveryModel deliveryModel) {
        return  deliveryService.save(deliveryModel);
    }

    @GetMapping(value = "/deliveries")
    public Page<DeliveryModel> getDeliveries(@PageableDefault @SortDefault.SortDefaults({ @SortDefault(sort = "createdDate", direction = Sort.Direction.DESC)}) Pageable pageable) {
        return  deliveryService.findAll(pageable);
    }
}
