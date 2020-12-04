package com.foodbank.foodbankapi.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "Deliveries")
@Where(clause="is_deleted=false")
public class DeliveryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @OneToOne
    private Long orderId;

//    @OneToOne
    private Long recipientId;

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
