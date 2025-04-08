package org.example;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaDupla lista = new ListaDupla();    //criar lista

        System.out.print("Informe o tipo de transporte ou região para filtro (Ônibus, Metrô, Zona Sul): ");
        String filtro = scanner.nextLine();

        carregarRotasDeArquivo(lista, "rotas_de_transportes.txt", filtro);

        System.out.println("\nRotas na ordem normal:");
        lista.exibirListaEmOrdem();

        System.out.println("\nRotas na ordem inversa:");
        lista.exibirListaEmOrdemInversa();


        lista.liberarLista();
    }


    public static void carregarRotasDeArquivo(ListaDupla lista, String nomeArquivo, String filtro) {
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) { //abre o arquivo
            String linha;

            // levando em consideração: id;linha;tipo;regiao

            while ((linha = br.readLine()) != null) {     //enquanto a linha não for null

                String[] dados = linha.split(";");  //carregar a linha, separando strings por ";"
                String id = dados[0].trim();              //id recebe a primeira parte
                String nomeLinha = dados[1].trim();       //segunda parte
                String tipoTransporte = dados[2].trim();  //terceira parte
                String regiaoAtendida = dados[3].trim();  //quarta parte

                // incluir a rota se atender a algum dos critérios inseridos pelo usuário
                if (tipoTransporte.equalsIgnoreCase(filtro) || regiaoAtendida.equalsIgnoreCase(filtro)) {
                    Rota rota = new Rota(id, nomeLinha, tipoTransporte, regiaoAtendida);
                    lista.inserirNaLista(rota);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
