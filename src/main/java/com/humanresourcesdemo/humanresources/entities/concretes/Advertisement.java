package com.humanresourcesdemo.humanresources.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "Advertisements")
@AllArgsConstructor
@NoArgsConstructor
public class Advertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "advertisement_id")
    private int advertisementId;

    @ManyToOne()
    @JoinColumn(name = "job_id")
    private Job job;

    @ManyToOne()
    @JoinColumn(name="city_id")
    private City city;

    @Column(name = "description")
    private String description;

    @Column(name = "min_salary")
    private float minSalary;

    @Column(name = "max_salary")
    private float maxSalary;

    @Column(name = "number_of_offer")
    private int numberOfOffer;

    @Column(name = "deadline")
    private Date deadline;

    @Column(name="statu")
    private boolean status;

    @Column(name = "created_date")
    private Date createdDate;


}
