package model;

import java.util.ArrayList;

public class Ator {
    private String nome;
    private String data_nascimento;
    private ArrayList<String> papeis;

    public Ator(String nome, String data_nascimento) {
        this.nome = nome;
        this.data_nascimento = data_nascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public ArrayList<String> getPapeis() {
        return papeis;
    }

    public void setPapeis(ArrayList<String> papeis) {
        this.papeis = papeis;
    }

    @Override
    public String toString() {
        return "nome: " + nome + '\n' +"papeis: " + papeis.toString();
    }
}
