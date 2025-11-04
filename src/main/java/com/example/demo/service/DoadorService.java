package com.example.demo.service;

import com.example.demo.clientFeign.DoacaoFeignClient;
import com.example.demo.dto.request.DoadorDtoRequest;
import com.example.demo.dto.response.DoacaoDtoResponse;
import com.example.demo.dto.response.DoadorComDoacoesResponse;
import com.example.demo.dto.response.DoadorDtoResponse;
import com.example.demo.entity.Doador;
import com.example.demo.repository.DoadorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoadorService {

    private final DoadorRepository doadorRepository;
    private final DoacaoFeignClient doacaoFeignClient;
    private final ModelMapper modelMapper;

    public DoadorService(DoadorRepository doadorRepository, DoacaoFeignClient doacaoFeignClient, ModelMapper modelMapper) {
        this.doadorRepository = doadorRepository;
        this.doacaoFeignClient = doacaoFeignClient;
        this.modelMapper = modelMapper;
    }

    public DoadorDtoResponse cadastrarDoador(DoadorDtoRequest request) {
        Doador doador = modelMapper.map(request, Doador.class);

        Doador doadorSalvo = doadorRepository.save(doador);

        return modelMapper.map(doadorSalvo, DoadorDtoResponse.class);
    }

    public List<DoadorComDoacoesResponse> consultarDoadoresComDoacoes() {
        List<Doador> doadores = doadorRepository.findAll();

        List<DoadorComDoacoesResponse> listaResposta = new ArrayList<>();

        for (Doador doador : doadores) {
            List<DoacaoDtoResponse> doacoesDoDoador;

            doacoesDoDoador = doacaoFeignClient.obterDoacoesDoUsuario(doador.getId());


            DoadorComDoacoesResponse doadorComDoacoes = modelMapper.map(doador, DoadorComDoacoesResponse.class);
            doadorComDoacoes.setDoacoes(doacoesDoDoador);

            listaResposta.add(doadorComDoacoes);
        }

        return listaResposta;
    }
}