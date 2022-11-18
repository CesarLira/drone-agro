package br.com.fiap.droneagro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.fiap.droneagro.dto.DroneDto;
import br.com.fiap.droneagro.models.Drone;
import br.com.fiap.droneagro.repositories.DroneRepository;

@Service
public class DroneService {
    
    final DroneRepository droneRepository;

    public DroneService(DroneRepository droneRepository) {
        this.droneRepository = droneRepository;
    }

    public Drone droneSave(DroneDto droneDto) {

        Drone drone = new Drone();

        drone.setDescricao(droneDto.getDescricao());
        drone.setAtivarRastreamento(droneDto.getAtivarRastreamento());

        return droneRepository.save(drone);
    }

    public List<Drone> findAll() {
        return droneRepository.findAll();
    }

    public Optional<Drone> findById(int id) {
        return droneRepository.findById(id);
    }
    
}
