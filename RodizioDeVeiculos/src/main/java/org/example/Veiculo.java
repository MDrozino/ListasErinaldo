package org.example;

public class Veiculo {
    private String placa;
    private String diaSemana;
    private String horario;

    // Construtor
    public Veiculo(String placa, String diaSemana, String horario) {
        this.placa = placa;
        this.diaSemana = diaSemana;
        this.horario = horario;
    }

    // Getters
    public String getPlaca() {
        return placa;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public String getHorario() {
        return horario;
    }

    // Método para exibir as informações do veículo
    public void exibir() {
        System.out.println("Placa: " + placa +" | Dia da Semana: " + diaSemana + " | Horário de Restrição: " + horario);
    }
}
