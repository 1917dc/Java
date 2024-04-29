package model;

public class Carro extends Veiculo {
    private String combustivel;
    public Carro(String nome, String marca, String modelo, String ano, String combustivel, String tipo) {
        super(nome, marca, modelo, ano, tipo);
        setCaracteristica(combustivel);
    }
    public String getCaracteristica() {
        return combustivel;
    }
    public void setCaracteristica(String combustivel) {
        this.combustivel = combustivel;
    }
}
