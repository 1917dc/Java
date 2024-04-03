import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean programa = true;
        int opcao;

        do {
            System.out.println("\n -- Digite qual o peso você deseja converter: -- \n");
            System.out.println("1 - Kilogramas;");
            System.out.println("2 - Libras;");
            System.out.println("3 - Ounces;");
            System.out.println("4 - Sair");
            opcao = scanner.nextInt();

            if (opcao == 1) {
                System.out.println("\n -- Digite o peso em Kilogramas: -- \n");
                boolean isValido = false;
                while (!isValido) {
                    try {
                        double pesoKgInput = scanner.nextDouble();
                        var pesoKg = new PesoKg(pesoKgInput);
                        isValido = true;
                        System.out.println("\n -- Digite a medida para conversão -- \n");
                        System.out.println("1 - Libras;");
                        System.out.println("2 - Ounces;");
                        opcao = scanner.nextInt();
                        if (opcao == 1) {
                            pesoKg.converterKgToLbs();
                        } else if (opcao == 2) {
                            pesoKg.converterKgToOunces();
                        }
                    } catch (ErroDeMedidaException e) {
                        scanner.next();
                        System.out.println(e.getMessage());
                    } catch (InputMismatchException e) {
                        scanner.next();
                        System.out.println(e.getStackTrace());
                        System.out.println("Digite um número.");
                    }
                }

            } else if (opcao == 2) {
                System.out.println("\n -- Digite o peso em Libras: -- \n");
                boolean isValido = false;
                while (!isValido) {
                    try {
                        double pesoLbsInput = scanner.nextDouble();
                        var pesoLbs = new PesoLbs(pesoLbsInput);
                        isValido = true;
                        System.out.println("\n -- Digite a medida para conversão -- \n");
                        System.out.println("1 - Kilos;");
                        System.out.println("2 - Ounces;");
                        opcao = scanner.nextInt();
                        if (opcao == 1) {
                            System.out.println("Peso em Kilogramas: ");
                            pesoLbs.converterLbsToKg();
                        } else if (opcao == 2) {
                            System.out.println("Peso em Ounces: ");
                            pesoLbs.converterLbsToOunces();
                        }
                    } catch (ErroDeMedidaException e) {
                        scanner.next();
                        System.out.println(e.getMessage());
                    } catch (InputMismatchException e) {
                        scanner.next();
                        System.out.println(e.getStackTrace());
                        System.out.println("Digite um número.");
                    }
                }
            } else if (opcao == 3) {
                System.out.println("\n -- Digite o peso em Kilogramas: -- \n");
                boolean isValido = false;
                while (!isValido) {
                    try {
                        double pesoOuncesInput = scanner.nextDouble();
                        var pesoOunces = new PesoOunces(pesoOuncesInput);
                        isValido = true;
                        System.out.println("\n -- Digite a medida para conversão -- \n");
                        System.out.println("1 - Kilos;");
                        System.out.println("2 - Libras;");
                        opcao = scanner.nextInt();
                        if (opcao == 1) {
                            pesoOunces.converterOuncesToKg();
                        } else if (opcao == 2) {
                            pesoOunces.converterOuncesToLbs();
                        }
                    } catch (ErroDeMedidaException e) {
                        scanner.next();
                        System.out.println(e.getMessage());
                    } catch (InputMismatchException e) {
                        scanner.next();
                        System.out.println(e.getStackTrace());
                        System.out.println("Digite um número.");
                    }
                }
            } else if (opcao == 4){
                programa = false;
            }
        } while (programa) ;

    }
}