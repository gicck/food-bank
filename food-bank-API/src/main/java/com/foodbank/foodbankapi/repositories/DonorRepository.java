package com.foodbank.foodbankapi.repositories;

import com.foodbank.foodbankapi.models.DonorModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonorRepository extends PagingAndSortingRepository<DonorModel, Long> {

}
