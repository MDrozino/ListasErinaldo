package org.example;

public class PontosColeta {
    String id;
    String tipoMaterial;
    String endereco;

    public PontosColeta(String id, String tipoMaterial, String endereco) {
        this.id = id;
        this.tipoMaterial = tipoMaterial;
        this.endereco = endereco;
    }

    public void exibir() {
        System.out.println("ID: " + id + ", Tipo de Material: " + tipoMaterial + ", Endereço: " + endereco);
    }
}
