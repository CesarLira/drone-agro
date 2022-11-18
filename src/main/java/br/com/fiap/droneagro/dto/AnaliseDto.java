package br.com.fiap.droneagro.dto;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

@Validated
public class AnaliseDto {

    @NotNull
    private int temperatura;

    @NotNull
    private int umidade;

    @NotNull
    private int droneId;

    @NotNull
    private double latitude;

    @NotNull
    private double longitude;


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

    public double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }  

    public int getDroneId() {
        return this.droneId;
    }

    public void setDroneId(int droneId) {
        this.droneId = droneId;
    }    

    @Override
    public String toString() {
        return "{" +
            " temperatura='" + getTemperatura() + "'" +
            ", umidade='" + getUmidade() + "'" +
            ", droneId='" + getDroneId() + "'" +
            ", latitude='" + getLatitude() + "'" +
            ", longitude='" + getLongitude() + "'" +
            "}";
    }    
}
