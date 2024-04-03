public class PesoLbs extends Peso{
    private static final double LIBRAS = 2.205;
    private static final double OUNCES = 16;
    public PesoLbs(double peso) throws ErroDeMedidaException {
        super(peso);
    }

    public double converterLbsToKg() {
        double pesoKg = getPeso() / LIBRAS;
        System.out.println(pesoKg);
        return pesoKg;
    }
    public double converterLbsToOunces(){
        double pesoOunces = getPeso() * OUNCES;
        System.out.println(pesoOunces);
        return pesoOunces;
    }
}
