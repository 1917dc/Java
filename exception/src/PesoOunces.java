public class PesoOunces extends Peso{
    public static final double KILOS = 35.274;
    public static final double LIBRAS = 16;
    public PesoOunces(double peso) throws ErroDeMedidaException {
        super(peso);
    }
    public double converterOuncesToKg(){
        double pesoKg = getPeso() / KILOS;
        System.out.println(pesoKg);
        return pesoKg;
    }
    public double converterOuncesToLbs(){
        double pesoLbs = getPeso() / LIBRAS;
        System.out.println(pesoLbs);
        return pesoLbs;
    }
}
