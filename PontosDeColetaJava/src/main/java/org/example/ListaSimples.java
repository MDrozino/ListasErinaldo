package org.example;

public class ListaSimples {
    private No lista;  // inicio da lista

    // nó
    private static class No {
        PontosColeta ponto;
        No proximo;     //referência para o próximo elemento

        No(PontosColeta ponto) {
            this.ponto = ponto;
            this.proximo = null;
        }
    }

    // inserir no fim
    public void adicionarPonto(String id, String tipoMaterial, String endereco) {
        PontosColeta ponto = new PontosColeta(id, tipoMaterial, endereco);
        No novoNo = new No(ponto);

        if (lista == null) {
            lista = novoNo;
        } else {
            No temp = lista;    //para não perder o inicio

            while (temp.proximo != null) {  //percorrer a lista até ser null
                temp = temp.proximo;
            }
            temp.proximo = novoNo;
        }
    }

    // imprime a lista
    public void exibirPontos() {
        if (lista == null) {
            System.out.println("Nenhum ponto de coleta encontrado.");
            return;
        }

        No temp = lista;
        while (temp != null) {
            temp.ponto.exibir();  // imprime o nó
            temp = temp.proximo;
        }
    }
}
