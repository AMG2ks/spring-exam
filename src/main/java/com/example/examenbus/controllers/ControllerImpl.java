package com.example.examenbus.controllers;

import com.example.examenbus.models.Bus;
import com.example.examenbus.models.Trajet;
import com.example.examenbus.models.Utilisateur;
import com.example.examenbus.services.IService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ControllerImpl {
    private final IService service;
    @PostMapping("/trajet")
    Trajet ajouterTrajet(@RequestBody Trajet trajet) {
        return service.ajouterTrajet(trajet);
    }

    @PostMapping("/etudiants")
    List<Utilisateur> ajouterEtudiants(@RequestBody List<Utilisateur> etudiants) {
        return service.ajouterEtudiants(etudiants);
    }

    @PostMapping("/bus")
    Bus ajouterBusEtChauffeur(@RequestBody Bus bus) {
        return service.ajouterBusEtChauffeur(bus);
    }

    @PutMapping("/bus/{numImma}/trajet/{idTrajet}")
    Bus affecterTrajetAuBus(@RequestBody String numImma, @RequestBody Long idTrajet) {
        return service.affecterTrajetAuBus(numImma, idTrajet);
    }

    @PutMapping("/bus/etudiant/{numImma}/{nom}/{prenom}")
    String affecterEtudiantABus(@PathVariable("num-immat") String numImma, @PathVariable("nom") String nom, @PathVariable("prenom") String prenom) {
        return service.affecterEtudiantABus(numImma, nom, prenom);
    }
}
