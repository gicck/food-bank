package com.foodbank.foodbankapi.repositories;

import com.foodbank.foodbankapi.models.DeliveryModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DeliveryRepository extends PagingAndSortingRepository<DeliveryModel, Long> {


}
