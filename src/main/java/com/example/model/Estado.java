package com.example.model;

public class Estado {
    private Long id;
    private String nome;
    private String uf;
    private RegiaoGeografia regiao;
    private int areakm2;
    private int populacao;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getUf() {
        return uf;
    }
    public void setUf(String uf) {
        this.uf = uf;
    }
    public RegiaoGeografia getRegiao() {
        return regiao;
    }
    public void setRegiao(RegiaoGeografia regiao) {
        this.regiao = regiao;
    }
    public int getAreakm2() {
        return areakm2;
    }
    public void setAreakm2(int areakm2) {
        this.areakm2 = areakm2;
    }
    public int getPopulacao() {
        return populacao;
    }
    public void setPopulacao(int populacao) {
        this.populacao = populacao;
    }

    public String toString() {
        return "Estado:" + nome + " ID: " + id + " UF: " + uf;
    }
}
