package com.foodbank.foodbankapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name="Items")
public class ItemModel {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private OrderModel orderModel;

    @Enumerated(EnumType.STRING)
    private ItemType itemType;

    private int quantity;

    private String name;

    private int capacity;

    private boolean isDeleted;

    @CreatedDate
    private LocalDateTime createdDate;
}

