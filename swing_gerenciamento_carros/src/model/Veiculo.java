package model;

import java.io.Serializable;

public abstract class Veiculo implements Serializable {
    private String nome;
    private String marca;
    private String modelo;
    private String ano;
    private String tipo;

    public Veiculo(String nome, String marca, String modelo, String ano, String tipo) {
        setNome(nome);
        setMarca(marca);
        setAno(ano);
        setModelo(modelo);
        setTipo(tipo);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return getNome();
    }

    public abstract String getCaracteristica();
}
