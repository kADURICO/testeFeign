package com.example.demo.dto.response;

import java.util.List;

public class DoadorComDoacoesResponse {

    private Integer id;
    private String nome;
    private String endereco;
    private Integer status;
    private List<DoacaoDtoResponse> doacoes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<DoacaoDtoResponse> getDoacoes() {
        return doacoes;
    }

    public void setDoacoes(List<DoacaoDtoResponse> doacoes) {
        this.doacoes = doacoes;
    }
}