package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        ExchangeRateService api = new ExchangeRateService();
        ConversorDeMoeda conversor = new ConversorDeMoeda();

        System.out.println("Digite a moeda de origem (ex: USD): ");
        String origem = scanner.nextLine().toUpperCase();

        System.out.println("Digite a moeda de destino (ex: BRL): ");
        String destino = scanner.nextLine().toUpperCase();

        System.out.println("Digite o valor a ser convertido: ");
        double valor = scanner.nextDouble();

        String json = api.obterDados(origem);
        System.out.println("JSON retornado pela API:");
        System.out.println(json);
        double resultado = conversor.converter(json, destino, valor);

        System.out.printf("%.2f %s = %.2f %s%n", valor, origem, resultado, destino);
    }
}
