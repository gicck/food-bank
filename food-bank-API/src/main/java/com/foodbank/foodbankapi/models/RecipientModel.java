package com.foodbank.foodbankapi.models;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity(name="Recipients")
public class RecipientModel {
        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        private Long id;

        @JsonIgnore
        @OneToMany(mappedBy = "recipient")
        private List<DeliveryModel> deliveries = new ArrayList<DeliveryModel>();

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
