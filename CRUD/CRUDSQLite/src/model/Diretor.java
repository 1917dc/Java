package model;

public class Diretor {
    private String nome;
    private String data_nascimento;

    public Diretor(String nome, String data_nascimento) {
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
}
