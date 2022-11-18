package br.com.fiap.droneagro.dto;

public class DroneDto {

    private String descricao;

    private boolean ativarRastreamento;

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

    
}
