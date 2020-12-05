package com.foodbank.foodbankapi.services;

import com.foodbank.foodbankapi.models.CollectModel;
import com.foodbank.foodbankapi.repositories.CollectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollectService {

    @Autowired
    private CollectRepository collectRepository;

    public CollectModel save(CollectModel collectModel) {
        return collectRepository.save(collectModel);
    }
}
