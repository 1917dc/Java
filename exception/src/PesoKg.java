public class PesoKg extends Peso{
    private static final double LIBRAS = 2.205;
    private static final double OUNCES = 35.274;

    public PesoKg(double peso) throws ErroDeMedidaException {
        super(peso);
    }

    public double converterKgToLbs() {
        double pesoLbs = getPeso() * LIBRAS ;
        System.out.println(pesoLbs);
        return pesoLbs;
    }

    public double converterKgToOunces() {
        double pesoOunces = getPeso() * OUNCES;
        System.out.println(pesoOunces);
        return pesoOunces;
    }
}
