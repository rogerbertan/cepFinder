package com.alura.ui;

import com.alura.model.Address;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    String busca = "";

    public String getMenu() {
        System.out.println("Digite um CEP para busca (ou sair) : ");

        busca = scanner.nextLine();

        if (busca.equalsIgnoreCase("sair")) {
            return "sair";
        }
        return busca;
    }
}
