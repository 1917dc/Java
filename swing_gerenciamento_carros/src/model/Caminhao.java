package model;

public class Caminhao extends Veiculo {
    private String capacidade;
    public Caminhao(String nome, String marca, String modelo, String ano, String capacidade, String tipo) {
        super(nome, marca, modelo, ano, tipo);
        setCaracteristica(capacidade);
    }
    public String getCaracteristica() {
        return capacidade;
    }
    public void setCaracteristica(String capacidade) {
        this.capacidade = capacidade;
    }
}
