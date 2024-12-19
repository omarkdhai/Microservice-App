package com.example.Service1.Entities;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Adresse {
    private String rue;
    private String codePostalVille;
    private String complet;
}

