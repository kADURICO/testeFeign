package com.example.demo.controller;

import com.example.demo.dto.request.DoadorDtoRequest;
import com.example.demo.dto.response.DoadorComDoacoesResponse;
import com.example.demo.dto.response.DoadorDtoResponse;
import com.example.demo.service.DoadorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doador")
@CrossOrigin("*")
public class DoadorController {

    private final DoadorService doadorService;

    public DoadorController(DoadorService doadorService) {
        this.doadorService = doadorService;
    }

    @PostMapping("/cadastrardoador")
    public ResponseEntity<DoadorDtoResponse> cadastrarDoador(@RequestBody DoadorDtoRequest request) {
        DoadorDtoResponse response = doadorService.cadastrarDoador(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/consultardoacoesdosdoadores")
    public ResponseEntity<List<DoadorComDoacoesResponse>> consultarDoadoresComDoacoes() {
        List<DoadorComDoacoesResponse> response = doadorService.consultarDoadoresComDoacoes();
        return ResponseEntity.ok(response);
    }
}