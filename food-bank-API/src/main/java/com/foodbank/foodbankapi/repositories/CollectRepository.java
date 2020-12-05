package com.foodbank.foodbankapi.repositories;

import com.foodbank.foodbankapi.models.CollectModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectRepository extends PagingAndSortingRepository<CollectModel, Long> {

}
