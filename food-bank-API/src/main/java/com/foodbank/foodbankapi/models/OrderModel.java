package com.foodbank.foodbankapi.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity(name="Orders")
@Where(clause="is_deleted=false")
public class OrderModel {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "orderModel", cascade = CascadeType.ALL)
    private List<ItemModel> items;

    private String employeeName;

    private String entityName;

    private String entityEmployeeName;

    private String entityEmployeePhone;

    @Enumerated(EnumType.STRING)
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
