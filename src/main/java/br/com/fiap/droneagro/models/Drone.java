package br.com.fiap.droneagro.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Drone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idDrone;
    
    @Column()
    private String descricao;

    @Column(nullable = false)
    private boolean ativarRastreamento;

    @OneToMany(mappedBy = "droneAnalise", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Analise> analises;


    public int getIdDrone() {
        return this.idDrone;
    }

    public void setIdDrone(int idDrone) {
        this.idDrone = idDrone;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isAtivarRastreamento() {
        return this.ativarRastreamento;
    }

    public boolean getAtivarRastreamento() {
        return this.ativarRastreamento;
    }

    public void setAtivarRastreamento(boolean ativarRastreamento) {
        this.ativarRastreamento = ativarRastreamento;
    }

    public List<Analise> getAnalises() {
        return this.analises;
    }

    public void setAnalises(List<Analise> analises) {
        this.analises = analises;
    }
    
    @Override
    public String toString() {
        return "{" +
            " idDrone='" + getIdDrone() + "'" +
            ", descricao='" + getDescricao() + "'" +
            ", ativarRastreamento='" + isAtivarRastreamento() + "'" +
            ", analises='" + getAnalises() + "'" +
            "}";
    }
}
