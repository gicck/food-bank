package com.foodbank.foodbankapi.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity(name="Donors")
public class DonorModel {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @OneToMany(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "donor")
    private List<CollectModel> collects = new ArrayList<CollectModel>();

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
