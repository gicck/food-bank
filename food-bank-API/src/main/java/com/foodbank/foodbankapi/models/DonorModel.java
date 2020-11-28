package com.foodbank.foodbankapi.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name="Donors")
public class DonorModel {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String donorName;

    private String personName;

    private String phoneNumber;

    private String address;

    private String latitude;

    private String longitude;

    private boolean isDeleted;

    @CreatedDate
    private LocalDateTime createdDate;
}
