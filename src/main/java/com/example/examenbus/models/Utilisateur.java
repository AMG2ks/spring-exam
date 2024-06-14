package com.example.examenbus.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUtilisateur;
    private String nom;
    private String prenom;
    private LocalDate dateDebutAbonnement;
    private LocalDate dateFinAbonnement;
    @Enumerated(EnumType.STRING)
    private Role role;
    //bidirectionnelle avec etudiant
    @ManyToOne
    private Bus busEtudiant;
}
