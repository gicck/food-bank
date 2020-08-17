package com.foodbank.foodbankapi.repositories;

import com.foodbank.foodbankapi.models.ItemModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends PagingAndSortingRepository<ItemModel, Long> {
}