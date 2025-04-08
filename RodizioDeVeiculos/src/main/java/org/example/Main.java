package org.example;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaCircular listaCircular = new ListaCircular();



        while (true) {
            System.out.print("\nDigite um critério de busca (final da placa ou dia da semana) ou 'sair' para encerrar: ");
            String criterio = scanner.nextLine();

            if (criterio.equalsIgnoreCase("sair")) {
                break;
            }

            //coloca na lista as linhas que correspondem ao criterio
            carregarVeiculos(listaCircular, criterio);

            //imprime a lista
            System.out.println("Veiculos encontrados: ");
            listaCircular.exibirLista();
        }

        System.out.println("Programa encerrado.");
    }

    // adiciona todos veiculos na lista circular
    public static void carregarVeiculos(ListaCircular listaCircular, String criterio) {
        try (BufferedReader br = new BufferedReader(new FileReader("rodizio_de_veiculos.txt"))) {
            String linha;

            //sabendo que cada linha: placa;dia;horario

            while ((linha = br.readLine()) != null) {       //enquanto tiver linhas
                String[] dados = linha.split(";");    //separa a linha a cada ";"
                String placa = dados[0].trim();             //placa recebe a primeira parte
                String diaSemana = dados[1].trim();         //segunda parte
                String horario = dados[2].trim();           //terceira parte

                if (placa.endsWith(criterio) || diaSemana.equalsIgnoreCase(criterio)) {
                    Veiculo veiculo = new Veiculo(placa, diaSemana, horario);
                    listaCircular.adicionarVeiculo(veiculo);  // adicionar apenas se corresponder ao critério
                }

            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar os dados do arquivo.");
        }
    }
}
