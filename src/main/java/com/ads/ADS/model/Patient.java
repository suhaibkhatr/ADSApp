package com.ads.ADS.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "patients")
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String contactPhoneNumber;
    private String email;
    private Date dateOfBirth;

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;

    @Embedded
    private Address address;

}
