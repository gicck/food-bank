package com.foodbank.foodbankapi.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name="Recipients")
public class RecipientModel {
        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        private Long id;

        private String recipientName;

        private int recipientQuantity;

        private String personName;

        private String phoneNumber;

        private String address;

        private String latitude;

        private String longitude;

        private boolean isDeleted;

        @CreatedDate
        private LocalDateTime createdDate;
}
