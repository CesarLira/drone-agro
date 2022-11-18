package br.com.fiap.droneagro.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.droneagro.dto.DroneDto;
import br.com.fiap.droneagro.models.Drone;
import br.com.fiap.droneagro.services.DroneService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@RestController
@RequestMapping("/drone")
@SwaggerDefinition(tags = {
    @Tag(name = "Drones", description = "Recursos da API de drones")
})
public class DroneController {
    
    final DroneService droneService;

    public DroneController(DroneService droneService) {
        this.droneService = droneService;
    }

    @ApiOperation(value = "Listar drones", notes = "Endpoit responsável por retornar uma lista de drones")
    @ApiResponses({
        @ApiResponse(code = 200, message = "Retorna todos os drones cadastrados")
    })
    @GetMapping
    public  ResponseEntity<List<Drone>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(droneService.findAll());
    }

    @ApiOperation(value = "Consulta um drone a partir do ID", notes = "Endpoint responsável por consultar drone através do ID")
    @ApiResponses({
        @ApiResponse(code = 200, message = "Retorna informações de um drone")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Drone>> findById(@PathVariable int id) 
    {
        return ResponseEntity.status(HttpStatus.OK).body(droneService.findById(id));
    }

    @ApiOperation(value = "Insere um drone", notes = "Endpoint responsável por inserir um drone")
    @ApiResponses({
        @ApiResponse(code = 200, message = "Insere informações de um drone")
    })
    @PostMapping
    public ResponseEntity<Drone> save(@RequestBody @Valid DroneDto drone)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(droneService.droneSave(drone));
    }

    // @ApiOperation(value = "Atualiza um drone", notes = "Endpoint responsável por atualizarr um drone")
    // @ApiResponses({
    //     @ApiResponse(code = 200, message = "Atualiza informações de um drone")
    // })
    // @PutMapping
	// public ResponseEntity<DroneDto> updateDrone(@RequestBody DroneDto drone) {
	// 	droneService.droneSave(drone);
	// 	return new ResponseEntity<DroneDto>(drone, HttpStatus.OK);
	// }
    
}
