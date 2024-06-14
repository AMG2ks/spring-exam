package com.example.examenbus.services;

import com.example.examenbus.models.Bus;
import com.example.examenbus.models.Role;
import com.example.examenbus.models.Trajet;
import com.example.examenbus.models.Utilisateur;
import com.example.examenbus.repositories.BusRepository;
import com.example.examenbus.repositories.TrajetRepository;
import com.example.examenbus.repositories.UtilisateurRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
@Slf4j
public class ServiceImpl implements IService{
    BusRepository busRepository;
    TrajetRepository trajetRepository;
    UtilisateurRepository utilisateurRepository;
    @Override
    public Trajet ajouterTrajet(Trajet trajet) {
        return trajetRepository.save(trajet);
    }

    @Override
    public List<Utilisateur> ajouterEtudiants(List<Utilisateur> etudiants) {
        return utilisateurRepository.saveAll(etudiants);
    }

    @Override
    public Bus ajouterBusEtChauffeur(Bus bus) {
        bus.getChauffeur().setRole(Role.CHAUFFEUR);
        return busRepository.save(bus);
    }

    @Override
    public Bus affecterTrajetAuBus(String numImma, Long idTrajet) {
        Trajet trajet = trajetRepository.findById(idTrajet).orElse(null);
        Bus bus = busRepository.findByNumImmatriculation(numImma);
        bus.setTrajet(trajet);
        return busRepository.save(bus);
    }

    @Override
    public String affecterEtudiantABus(String numImma, String nom, String prenom) {
        Bus bus = busRepository.findByNumImmatriculation(numImma);
        Utilisateur utilisateur = utilisateurRepository.findUtilisateurByNomAndPrenom(nom, prenom);
        if (utilisateurRepository.countUtilisateursByBusEtudiant_NumImmatriculation(numImma) < bus.getNbreDePlaceMax()) {
            log.info("nombre d'étudiants dans le bus : {}", utilisateurRepository.countUtilisateursByBusEtudiant_NumImmatriculation(numImma));
            utilisateur.setBusEtudiant(bus);
            utilisateurRepository.save(utilisateur);
            return "Etudiant ajouté";
        }
        else
            return "Bus complet";
    }

}
