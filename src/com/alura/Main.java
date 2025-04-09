package com.alura;


import com.alura.model.Address;
import com.alura.service.CepService;
import com.alura.service.FileService;
import com.alura.ui.Menu;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Menu myMenu = new Menu();
        CepService cepService = new CepService();
        FileService fileService = new FileService();
        String cep = "";

        while (!cep.equalsIgnoreCase("sair")) {
            cep = myMenu.getMenu();

            if (cep.equalsIgnoreCase("sair")) {
                fileService.saveToFile();
                break;
            }

            Address address = cepService.consultaCep(cep);

            fileService.addAddress(address);

            System.out.println(address);
        }
    }
}