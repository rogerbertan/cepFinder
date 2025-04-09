package com.alura.model;

public record Address(String logradouro, String complemento, String bairro, String localidade, String estado) {
    @Override
    public String toString() {
        return "(Logradouro= " + logradouro +
                " , complemento= " + complemento +
                " , bairro= " + bairro +
                " , localidade= " + localidade +
                " , estado= " + estado +
                ")";
    }
}
