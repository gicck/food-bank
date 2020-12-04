package com.foodbank.foodbankapi.repositories;

import com.foodbank.foodbankapi.models.DeliveryModel;
import com.foodbank.foodbankapi.models.OrderModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveryRepository extends PagingAndSortingRepository<DeliveryModel, Long> {


}
