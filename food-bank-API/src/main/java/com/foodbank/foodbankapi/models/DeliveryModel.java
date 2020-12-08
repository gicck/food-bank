package com.foodbank.foodbankapi.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;

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


    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "recipient_id", nullable = false)
    private RecipientModel recipient;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    private OrderModel order;

    private String description;

    private String fromName;

    private String fromPhone;

    private String toAddress;

    private String toName;

    private String toPhone;

    private LocalDateTime pickupTime;

    private LocalDateTime arrivalTime;

    private String instructions;

    private boolean isDeleted;

    @CreatedDate
    private LocalDateTime createdDate;

}
