package com.example.examenbus.repositories;

import com.example.examenbus.models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    Utilisateur findUtilisateurByNomAndPrenom(String nom, String prenom);
    @Query("select count(u) from Utilisateur u where u.busEtudiant.numImmatriculation = ?1")
    long countUtilisateursByBusEtudiant_NumImmatriculation(String numImmatriculation);
}
