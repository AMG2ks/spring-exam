package com.example.examenbus.services;

import com.example.examenbus.models.Bus;
import com.example.examenbus.models.Trajet;
import com.example.examenbus.models.Utilisateur;

import java.util.List;

public interface IService {
    Trajet ajouterTrajet(Trajet trajet);
    List<Utilisateur> ajouterEtudiants(List<Utilisateur> etudiants);

    Bus ajouterBusEtChauffeur(Bus bus);
    Bus affecterTrajetAuBus(String numImma, Long idTrajet);
    String affecterEtudiantABus(String numImma, String nom, String prenom);
}
