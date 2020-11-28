package com.foodbank.foodbankapi.services;

import com.foodbank.foodbankapi.models.DonorModel;
import com.foodbank.foodbankapi.repositories.DonorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DonorService {

    @Autowired
    private DonorRepository donorRepository;

    public DonorModel save(DonorModel donorModel) {
        return donorRepository.save(donorModel);
    }

    public void softDelete(long id) {
        donorRepository.findById(id).map(donor -> {
            donor.setDeleted(true);
            return donorRepository.save(donor);
        });
    }

    public Page<DonorModel> findAll(Pageable pageable) {
        return  donorRepository.findAll(pageable);
    }

    public Optional<DonorModel> findById(long donorId){
        return  donorRepository.findById(donorId);
    }
}
