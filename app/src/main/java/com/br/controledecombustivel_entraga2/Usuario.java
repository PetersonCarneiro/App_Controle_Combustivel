package com.br.controledecombustivel_entraga2;

public class Usuario {

    private String nome;
    private TipoCombustivel tipoCombustivel;
    private TipoVeiculo tipoVeiculo;
    private float precoCombustivel;
    private float Distancia;
    private float kmLitro;

    public Usuario(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTipoCombustivel() {
        return tipoCombustivel.ordinal();
    }

    public void setTipoCombustivel(TipoCombustivel tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    public int getTipoVeiculo() {
        return tipoVeiculo.ordinal();
    }

    public void setTipoVeiculo(TipoVeiculo tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }


    public float getPrecoCombustivel() {
        return precoCombustivel;
    }

    public void setPrecoCombustivel(float PrecoCombustivel) {
        this.precoCombustivel = PrecoCombustivel;
    }

    public float getDistancia() {
        return Distancia;
    }

    public void setDistancia(float kmDistancia) {
        this.Distancia = kmDistancia;
    }

    public float getKmLitro() {
        return kmLitro;
    }

    public void setKmLitro(float kmLitro) {
        this.kmLitro = kmLitro;
    }

    @Override
    public String toString() {
        return
                "nome=" + nome +
                ", tipoCombustivel=" + tipoCombustivel +
                ", tipoVeiculo=" + tipoVeiculo +
                '}';
    }
}
