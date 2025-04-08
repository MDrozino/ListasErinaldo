package org.example;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaSimples lista = new ListaSimples();    //cria a lista


            System.out.print("Informe o tipo de material para busca (exemplo: Plástico, Vidro, Eletrônicos): ");
            String tipoMaterialBusca = scanner.nextLine();


            // abre o txt
            try (BufferedReader br = new BufferedReader(new FileReader("pontos_de_descartes.txt"))) {
                String linha;

                while ((linha = br.readLine()) != null) {   //para cada linha
                    String[] dados = linha.split(";");      //pega a linha inteira e reparte quando ouver ";"
                    String id = dados[0].trim();                  //recebe a primeira parte da linha
                    String tipoMaterial = dados[1].trim();        //segunda parte
                    String endereco = dados[2].trim();            //terceira parte


                    //se o elemento do txt for igual a entrada do usuario adiciona na lista
                    if (tipoMaterial.equalsIgnoreCase(tipoMaterialBusca)) {
                        lista.adicionarPonto(id, tipoMaterial, endereco);
                    }

                }
            } catch (IOException e) {
                System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            }

            // mostra a lista
            System.out.println("\nPontos de descarte encontrados para '" + tipoMaterialBusca + "':");
            lista.exibirPontos();

    }
}
