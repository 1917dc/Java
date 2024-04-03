public abstract class Peso {
    private double peso;

    public Peso(double peso) throws ErroDeMedidaException {
        setPeso(peso);
    }

    public void setPeso(double peso) throws ErroDeMedidaException{
        if(peso > 0){
            this.peso = peso;
        } else {
            throw new ErroDeMedidaException("O peso não pode ser negativo");
        }
    }
    public double getPeso() {
        return peso;
    }

}
