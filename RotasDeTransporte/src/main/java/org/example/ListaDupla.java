package org.example;

public class ListaDupla {

    private No inicio;
    private No fim;

    //declaração do nó
    private static class No {
        Rota rota;
        No ant;  // Ponteiro para o nó anterior
        No prox;  // Ponteiro para o próximo nó


        No(Rota rota) {
            this.rota = rota;
            this.ant = null;
            this.prox = null;
        }
    }

    //inserir no fim
    public void inserirNaLista(Rota rota) {
        No novoNo = new No(rota);
        if (inicio == null) {
            inicio = novoNo;
            fim = novoNo;
        } else {
            fim.prox = novoNo;
            novoNo.ant = fim;
            fim = novoNo;
        }
    }

    public void exibirListaEmOrdem() {
        if (inicio == null) {
            System.out.println("Nenhuma rota encontrada.");
            return;
        }

        No temp = inicio;
        while (temp != null) {  //percorrer e exibir
            temp.rota.exibir();
            temp = temp.prox;
        }
    }

    // Exibir a lista na ordem inversa
    public void exibirListaEmOrdemInversa() {
        if (fim == null) {
            System.out.println("Nenhuma rota encontrada.");
            return;
        }

        No temp = fim;
        while (temp != null) {      //percorrer e exibir de trás pra frente
            temp.rota.exibir();
            temp = temp.ant;
        }
    }

    // Liberar a memória da lista
    public void liberarLista() {
        inicio = null;
        fim = null;
    }
}
