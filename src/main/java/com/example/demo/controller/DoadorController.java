package com.example.demo.controller;

import com.example.demo.dto.DoadorDtoRequest;
import com.example.demo.dto.DoadorDtoResponse;
import com.example.demo.entity.Doador;
import com.example.demo.service.DoadorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/doador")
@Tag(name="Doador", description = "Api para gerenciamento dos doadores do sistema")
public class DoadorController {

    private final DoadorService doadorService;

    public DoadorController(DoadorService doadorService) {
        this.doadorService = doadorService;
    }
    
    @GetMapping("/listar")
    @Operation(summary = "Listar doadores do sistema")
    public ResponseEntity<List<Doador>> listar(){
        return ResponseEntity.ok(doadorService.listarDoadores());
    }

    @GetMapping("/consultarDoacoesDoadores")
    @Operation(summary = "Listar doadores com suas doações")
    public ResponseEntity<List<Doacao>> consultarDoacoesDoadores(){
        return ResponseEntity.ok(doadorService.listarDoacoesDoador());
    }

    @PostMapping("/cadastrarDoador")
    @Operation(summary = "Cadastrar um novo doador")
    public ResponseEntity<DoadorDtoResponse> cadastrarDoador(@Valid @RequestBody DoadorDtoRequest doadorDtoRequest){
        return ResponseEntity.ok(doadorService.salvar(doadorDtoRequest));
    }
}
