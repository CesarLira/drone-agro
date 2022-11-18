package br.com.fiap.droneagro.dto;

public class MessageDto {

    private int idDrone;
    private int temperatura;
    private int umidade;

    public int getIdDrone() {
        return this.idDrone;
    }

    public void setIdDrone(int idDrone) {
        this.idDrone = idDrone;
    }

    public int getTemperatura() {
        return this.temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    public int getUmidade() {
        return this.umidade;
    }

    public void setUmidade(int umidade) {
        this.umidade = umidade;
    }

    
}
