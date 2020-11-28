package com.foodbank.foodbankapi.controllers;

import com.foodbank.foodbankapi.models.DonorModel;
import com.foodbank.foodbankapi.services.DonorService;
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
public class DonorController {

    @Autowired
    private DonorService donorService;

    @PostMapping(value = "/donors")
    public DonorModel saveDonor(@RequestBody DonorModel donorModel) {

        donorModel.setCreatedDate(LocalDateTime.now(ZoneOffset.UTC));

        return  donorService.save(donorModel);
    }

    @GetMapping(value = "/donors")
    public Page<DonorModel> getDonors(@PageableDefault @SortDefault.SortDefaults({ @SortDefault(sort = "createdDate", direction = Sort.Direction.DESC)}) Pageable pageable) {
        return  donorService.findAll(pageable);
    }

    @GetMapping(value = "/donors/{id}")
    public Optional<DonorModel> getDonorById(@PathVariable long id) {
        return donorService.findById(id);
    }

    @DeleteMapping(value = "/donors/{id}")
    public void softDeleteDonorById(@PathVariable long id) {
        donorService.softDelete(id);
    }
}
