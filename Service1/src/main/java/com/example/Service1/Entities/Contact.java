package com.example.Service1.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "contacts")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Long id;

    private String nomPrenom;

    private String telephone;

    private String email;
    @Embedded
    private Adresse adresse;
}
