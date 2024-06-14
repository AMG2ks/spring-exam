package com.example.examenbus.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBus;
    private String numImmatriculation;
    private LocalDate dateMiseEnService;
    private int nbreDePlaceMax;
    @ManyToOne
    private Trajet trajet;

    //unidirectionnelle avec chauffeur
    @OneToOne(cascade = CascadeType.ALL)
    private Utilisateur chauffeur;

    //bidirectionnelelle avec etudiant
    @OneToMany(mappedBy = "busEtudiant")
    private Set<Utilisateur> etudiants;
}
