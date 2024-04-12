package com.ads.ADS.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String contactPhoneNumber;
    private String email;
    private Date dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}
