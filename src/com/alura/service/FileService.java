package com.alura.service;

import com.alura.model.Address;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    FileWriter writer = new FileWriter("cep.json");
    List<Address> addresses = new ArrayList<>();
    CepService cepService = new CepService();

    public List<Address> getAddresses() {
        return addresses;
    }

    public void addAddress(Address address) {
        addresses.add(address);
    }

    public FileService() throws IOException {
    }
    public void saveToFile() {
        try {
            writer.write(cepService.toJson(addresses));
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
