package com.example.demo.clientFeign;

import com.example.demo.dto.response.DoacaoDtoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(name = "Doacao", url = "10.136.64.203:8080", path = "/doacao")
public interface DoacaoFeignClient {

    @GetMapping("/obterdoacoesdousuario/{doadorId}")
    List<DoacaoDtoResponse> obterDoacoesDoUsuario(@PathVariable("doadorId") Integer doadorId);
}