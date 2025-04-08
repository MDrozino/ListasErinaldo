package org.example;

public class Rota {
    String id;
    String nomeLinha;
    String tipoTransporte;
    String regiaoAtendida;

    public Rota(String id, String nomeLinha, String tipoTransporte, String regiaoAtendida) {
        this.id = id;
        this.nomeLinha = nomeLinha;
        this.tipoTransporte = tipoTransporte;
        this.regiaoAtendida = regiaoAtendida;
    }

    public void exibir() {
        System.out.println("ID: " + id + ", Linha: " + nomeLinha + ", Tipo: " + tipoTransporte + ", Região: " + regiaoAtendida);
    }
}
