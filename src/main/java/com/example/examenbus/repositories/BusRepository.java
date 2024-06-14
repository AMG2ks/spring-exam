package com.example.examenbus.repositories;

import com.example.examenbus.models.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusRepository extends JpaRepository<Bus, Long> {
    Bus findByNumImmatriculation(String numImmatriculation);
}
