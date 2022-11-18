package br.com.fiap.droneagro.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.droneagro.dto.AnaliseDto;
import br.com.fiap.droneagro.models.Analise;
import br.com.fiap.droneagro.services.AnaliseService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@RestController
@RequestMapping("/analise")
@SwaggerDefinition(tags = {
    @Tag(name = "Analises", description = "Recursos da API de analises")
})
public class AnaliseController {

    final AnaliseService analiseService;

    public AnaliseController(AnaliseService analiseService) {
        this.analiseService = analiseService;
    }

    @ApiOperation(value = "Listar analises", notes = "Endpoit responsável por retornar uma lista de analises")
    @ApiResponses({
        @ApiResponse(code = 200, message = "Retorna todos as analises cadastradas")
    })
    @GetMapping
    public  ResponseEntity<List<Analise>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(analiseService.findAll());
    }

    @ApiOperation(value = "Consulta uma analise a partir do ID", notes = "Endpoint responsável por consultar analise através do ID")
    @ApiResponses({
        @ApiResponse(code = 200, message = "Retorna informações de uma analise")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Analise>> findById(@PathVariable int id) 
    {
        return ResponseEntity.status(HttpStatus.OK).body(analiseService.findById(id));
    }

    @ApiOperation(value = "Insere uma analise", notes = "Endpoint responsável por inserir uma analise")
    @ApiResponses({
        @ApiResponse(code = 200, message = "Insere informações de uma analise")
    })
    @PostMapping
    public ResponseEntity<Analise> save(@RequestBody @Valid AnaliseDto analiseDto) throws Exception
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(analiseService.analiseSave(analiseDto));
    }

    @ApiOperation(value = "Atualiza uma analise", notes = "Endpoint responsável por atualizarr uma analise")
    @ApiResponses({
        @ApiResponse(code = 200, message = "Atualiza informações de uma analise")
    })
    @PutMapping
	public ResponseEntity<Analise> updateanalise(@RequestBody AnaliseDto analiseDto) throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(analiseService.analiseSave(analiseDto));
	}
    
}
