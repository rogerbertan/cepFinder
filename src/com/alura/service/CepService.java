package com.alura.service;

import com.alura.model.Address;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class CepService {
    private static final String URL = "http://viacep.com.br/ws/%s/json/";
    private Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    public Address consultaCep(String cep) throws IOException, InterruptedException {
        cep = cep.replaceAll("\\D", "");

        if (cep.length() != 8) {
            throw new IllegalArgumentException("CEP deve conter 8 digitos");
        }

        String url = String.format(URL, cep);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200){
            throw new RuntimeException("Erro ao buscar o CEP: " + response.statusCode());
        }

        String json = response.body();

        if (json.contains("\"erro\"")) {
            throw new RuntimeException("CEP não encontrado");
        }

        return gson.fromJson(json, Address.class);
    }

    public String toJson(List address) {
        return gson.toJson(address);
    }
}
