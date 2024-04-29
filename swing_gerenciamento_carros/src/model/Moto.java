package model;

public class Moto extends Veiculo {
    private String cilindradas;
    public Moto(String nome, String marca, String modelo, String ano, String cilindradas, String tipo) {
        super(nome, marca, modelo, ano, tipo);
        setCaracteristica(cilindradas);
    }
    public String getCaracteristica() {
        return cilindradas;
    }
    public void setCaracteristica(String cilindradas) {
        this.cilindradas = cilindradas;
    }
}
