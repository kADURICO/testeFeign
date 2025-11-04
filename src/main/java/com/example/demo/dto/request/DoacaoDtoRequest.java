package com.example.demo.dto.request;

import java.util.Date;

public class DoacaoDtoRequest {
    private Date data;
    private Integer valor;
    private Integer status;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
