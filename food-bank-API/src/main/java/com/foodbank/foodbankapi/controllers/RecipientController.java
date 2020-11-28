package com.foodbank.foodbankapi.controllers;

import com.foodbank.foodbankapi.models.RecipientModel;
import com.foodbank.foodbankapi.services.RecipientService;
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
public class RecipientController {

    @Autowired
    private RecipientService recipientService;

    @PostMapping(value = "/recipients")
    public RecipientModel saveRecipient(@RequestBody RecipientModel recipientModel) {

        recipientModel.setCreatedDate(LocalDateTime.now(ZoneOffset.UTC));

        return  recipientService.save(recipientModel);
    }

    @GetMapping(value = "/recipients")
    public Page<RecipientModel> getRecipients(@PageableDefault @SortDefault.SortDefaults({ @SortDefault(sort = "createdDate", direction = Sort.Direction.DESC)}) Pageable pageable) {
        return  recipientService.findAll(pageable);
    }

    @GetMapping(value = "/recipients/{id}")
    public Optional<RecipientModel> getRecipientById(@PathVariable long id) {
        return recipientService.findById(id);
    }

    @DeleteMapping(value = "/recipients/{id}")
    public void softDeleteRecipientById(@PathVariable long id) {
        recipientService.softDelete(id);
    }
}
