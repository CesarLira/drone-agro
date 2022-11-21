package br.com.fiap.droneagro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.fiap.droneagro.dto.AnaliseDto;
import br.com.fiap.droneagro.models.Analise;
import br.com.fiap.droneagro.models.Drone;
import br.com.fiap.droneagro.repositories.AnaliseRepository;
import br.com.fiap.droneagro.repositories.DroneRepository;
import br.com.fiap.droneagro.sender.QueueSender;

@Service
public class AnaliseService {

    final AnaliseRepository analiseRepository;
    final DroneRepository droneRepository;
    final QueueSender queueSender;

    public AnaliseService(
        AnaliseRepository analiseRepository, 
        DroneRepository droneRepository,
        QueueSender queueSender) {
            this.analiseRepository = analiseRepository;
            this.droneRepository = droneRepository;
            this.queueSender = queueSender;
    }

    public Analise analiseSave(AnaliseDto analiseDto) throws Exception {

        Optional<Drone> droneDto = droneRepository.findById(analiseDto.getDroneId());

        if(droneDto.isEmpty()) 
        {
            throw new Exception("Drone informado invalido");
        }
        
        // Latitude de -90 a 90

        if(analiseDto.getLatitude() < -90d || 
            analiseDto.getLatitude() > 90d)
        {
            throw new Exception("Latitue invalida");
        }

        // Longitude de -180 a 180
        if(analiseDto.getLongitude() < -180d ||
            analiseDto.getLongitude() > 180d)
        {
            throw new Exception("Longitude invalida");
        }

        if(analiseDto.getTemperatura() < -25 ||
            analiseDto.getTemperatura() > 40)
        {
            throw new Exception("Temperatura invalida");
        }

        if(analiseDto.getUmidade() < 0 ||
            analiseDto.getUmidade() >100)
        {
            throw new Exception("Umidade informada invalida");
        }

        Analise analise = new Analise();

        analise.setLatitude(analiseDto.getLatitude());
        analise.setLongitude(analiseDto.getLongitude());
        analise.setTemperatura(analiseDto.getTemperatura());
        analise.setUmidade(analiseDto.getUmidade());

        Drone drone = new Drone();

        drone.setAtivarRastreamento(droneDto.get().getAtivarRastreamento());
        drone.setDescricao(droneDto.get().getDescricao());
        drone.setIdDrone(droneDto.get().getIdDrone());

        analise.setDroneAnalise(drone);

        var msg = analise.getTemperatura() + ":" + analise.getUmidade() + ":" + analise.getDroneAnalise().getIdDrone();

        queueSender.send(msg);
        
        return analiseRepository.save(analise);
    }

    public List<Analise> findAll() {
        return analiseRepository.findAll();
    }

    public Optional<Analise> findById(int id) {
        return analiseRepository.findById(id);
    }
    
}
