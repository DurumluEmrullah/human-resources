package com.humanresourcesdemo.humanresources.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name="workers")
@AllArgsConstructor
@NoArgsConstructor
public class Worker extends User{

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="identification_number")
    private String identificationNumber;

    @Column(name="birth_year")
    private int birthYear;

    @Column(name="email_verify")
    private boolean emailVerify;
}
