import org.w3c.dom.ls.LSOutput;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Aluno> alunos = new HashMap<>();

        boolean programa = true;

        do{
            System.out.println("Sistema de Cadastro Un-DF");
            System.out.println("Digite a opção desejada:");
            System.out.println("1 - Adicionar aluno");
            System.out.println("2 - Exibir alunos");
            System.out.println("3 - Pesquisar Aluno");
            System.out.println("3 - Sair");
            int opcao = scanner.nextInt();
            if(opcao == 1){
                System.out.println("Digite o nome do aluno:");
                String nome = scanner.next();
                System.out.println("Digite o CPF do aluno:");
                String cpf = scanner.next();
                System.out.println("Digite a data de nascimento do aluno:");
                String dataNascimento = scanner.next();
                alunos.put(cpf, new Aluno(cpf, nome, dataNascimento));
            } else if (opcao == 2){
                alunos.forEach((k, v) -> System.out.println("CPF: " + k +"\n"+ "NOME: " + v.getNome() +"\n"+ "DATA DE NASCIMENTO: "+ v.getDataNascimento() + "\n"));
            } else if(opcao == 3){
                System.out.println("Digite o CPF do aluno:");
                String cpf = scanner.next();
                System.out.println("Aluno: " + alunos.get(cpf).getNome());
                System.out.println("CPF: " + alunos.get(cpf).getCpf());
                System.out.println("Data Nascimento: " + alunos.get(cpf).getDataNascimento());
            } else {
                programa = false;
            }

        } while(programa);

    }
}