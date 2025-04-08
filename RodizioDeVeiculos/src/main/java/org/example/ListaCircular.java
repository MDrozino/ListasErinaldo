package org.example;

public class ListaCircular {
    private No inicio;  //primeiro nó
    private No fim;     //último nó

    // declaração do nó
    private class No {
        Veiculo veiculo;
        No proximo;     //referencia proximo nó
        No anterior;    //referencia nó anterior

        public No(Veiculo veiculo) {
            this.veiculo = veiculo;
            this.proximo = null;
            this.anterior = null;
        }
    }

    // inserir no fim da lista
    public void adicionarVeiculo(Veiculo veiculo) {
        No novoNo = new No(veiculo);

        if (inicio == null) {
            inicio = novoNo;
            fim = novoNo;
            inicio.proximo = inicio;
            inicio.anterior = inicio;
        } else {
            fim.proximo = novoNo;       //fim se torna o penultimo
            novoNo.anterior = fim;
            novoNo.proximo = inicio;    //fim aponta pro começo
            inicio.anterior = novoNo;   //começo aponta pro fim
            fim = novoNo;               //novo no se torna o final
        }
    }

    public void exibirLista() {
        if (inicio == null) {
            System.out.println("Nenhuma rota encontrada.");
            return;
        }

        No temp = inicio;
        do {  // percorre a lista circular
            temp.veiculo.exibir();
            temp = temp.proximo;
        } while (temp != inicio);  // stop when we return to the start of the list
    }
}
