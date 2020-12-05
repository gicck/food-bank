package com.foodbank.foodbankapi.controllers;

import com.foodbank.foodbankapi.models.CollectModel;
import com.foodbank.foodbankapi.services.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class CollectController {

    @Autowired
    private CollectService collectService;

    @PostMapping(value = "/collects")
    public CollectModel saveCollect(@RequestBody CollectModel collectModel){
        return collectService.save(collectModel);
    }
}
