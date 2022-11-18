package br.com.fiap.droneagro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.droneagro.models.Drone;

public interface DroneRepository extends JpaRepository<Drone, Integer> {}
