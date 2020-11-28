package com.foodbank.foodbankapi.services;

import com.foodbank.foodbankapi.models.RecipientModel;
import com.foodbank.foodbankapi.repositories.RecipientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecipientService {

        @Autowired
        private RecipientRepository recipientRepository;

        public RecipientModel save(RecipientModel recipientModel) {
            return recipientRepository.save(recipientModel);
        }

        public void softDelete(long id) {
            recipientRepository.findById(id).map(recipient -> {
                recipient.setDeleted(true);
                return recipientRepository.save(recipient);
            });
        }

        public Page<RecipientModel> findAll(Pageable pageable) {
        return  recipientRepository.findAll(pageable);
    }

        public Optional<RecipientModel> findById(long recipientId){
        return  recipientRepository.findById(recipientId);
    }
}
