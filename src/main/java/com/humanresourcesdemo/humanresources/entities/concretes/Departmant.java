package com.humanresourcesdemo.humanresources.entities.concretes;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "departmants")
public class Departmant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "departmant_id")
    private int id;

    @Column(name = "departmant_name")
    private String departmantName;
}
