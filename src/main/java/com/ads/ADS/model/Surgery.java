package com.ads.ADS.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "surgeries")
@NoArgsConstructor
@AllArgsConstructor
public class Surgery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phoneNumber;

    @OneToMany(mappedBy = "surgery")
    private List<Appointment> appointments;
}
