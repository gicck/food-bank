package com.foodbank.foodbankapi.models;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity(name="Orders")
public class OrderModel {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String employeeName;

    private String entityName;

    private String entityEmployeeName;

    private String entityEmployeePhone;

    private OrderState state;

    private boolean isDeleted;

    @CreatedDate
    private LocalDateTime createdDate;

    private LocalDateTime packedDate;

    private LocalDateTime finalizedDate;

    private LocalDateTime dispatchedDate;

    private LocalDateTime acceptedDate;

    private LocalDateTime receivedDate;

    private LocalDateTime deletedDate;
}
