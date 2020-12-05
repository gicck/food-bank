package com.foodbank.foodbankapi.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name= "Collects")
public class CollectModel {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "donor_id", nullable = false)
    private DonorModel donor;

    private String fromAddress;

    private String fromName;

    private String fromPhone;

    private String toAddress;

    private String toName;

    private String toPhone;

    private LocalDateTime pickupTime;

    private LocalDateTime arrivalTime;

    private String instructions;
}
