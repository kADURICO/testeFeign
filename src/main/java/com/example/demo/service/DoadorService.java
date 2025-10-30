package com.example.demo.service;

import com.example.demo.dto.DoadorDtoRequest;
import com.example.demo.dto.DoadorDtoResponse;
import com.example.demo.entity.Doador;
import com.example.demo.repository.DoadorRepository;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoadorService {

    @Autowired
    private ModelMapper modelMapper;

    private final DoadorRepository doadorRepository;

    public DoadorService(DoadorRepository doadorRepository) {
        this.doadorRepository = doadorRepository;
    }
    
    public DoadorDtoResponse salvar(@Valid DoadorDtoRequest doadorDtoRequest) {
        Doador doador = new Doador();
        doador.setNome(doadorDtoRequest.getNome());
        doador.setEndereco(doadorDtoRequest.getEndereco());
        doador.setStatus(1);
        Doador doadorTemp = this.doadorRepository.save(doador);
        return modelMapper.map(doadorTemp, DoadorDtoResponse.class);
    }

    public List<Doador> listarDoadores(){
        return this.doadorRepository.listarDoadoresAtivos();
    }
}
