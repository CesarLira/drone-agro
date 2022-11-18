package br.com.fiap.droneagro.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Analise {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private int temperatura;

    @Column
    private int umidade;

    @Column
    private double latitude;

    @Column
    private double longitude;

    @ManyToOne()
    @JoinColumn(name = "ID_DRONE")
    @JsonBackReference
    private Drone droneAnalise;


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Drone getDroneAnalise() {
        return this.droneAnalise;
    }

    public void setDroneAnalise(Drone droneAnalise) {
        this.droneAnalise = droneAnalise;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", temperatura='" + getTemperatura() + "'" +
            ", umidade='" + getUmidade() + "'" +
            ", latitude='" + getLatitude() + "'" +
            ", longitude='" + getLongitude() + "'" +
            ", droneAnalise='" + getDroneAnalise() + "'" +
            "}";
    }
}
