package com.foodbank.foodbankapi.repositories;
import com.foodbank.foodbankapi.models.RecipientModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipientRepository extends PagingAndSortingRepository<RecipientModel, Long> {

}

