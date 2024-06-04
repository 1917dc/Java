package model;

public class Filme {
    private String titulo;
    private String ano;
    private Integer diretor_id;

    public Filme(String titulo, String ano, Integer diretor_id) {
        this.titulo = titulo;
        this.ano = ano;
        this.diretor_id = diretor_id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public Integer getDiretor_id() {
        return diretor_id;
    }

    public void setDiretor_id(int diretor_id) {
        this.diretor_id = diretor_id;
    }
}
