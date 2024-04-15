import java.util.Scanner;

public class InteracaoQuiz {
    Quiz quiz = new Quiz();
    Scanner scanner = new Scanner(System.in);
    public void menuQuiz(){
        Integer opcao = -1;

        while(opcao != 3){
            System.out.println("""
                -------- Sistema de Quiz --------
                1 - Registrar questão;
                2 - Começar quiz;
                3 - Sair do quiz;
                ---------------------------------
                """);
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch(opcao){
                case 1 -> registrarQuestão();
                case 2 -> jogarQuiz();
                case 3 -> {}
                default -> System.out.println("Opção inválida.");
            }
        }
    }

    private void jogarQuiz() {
        for(Questao questao : quiz.getQuestoes()){
            System.out.println(questao.pergunta());
            String resposta = scanner.nextLine();
            if(quiz.verificarResposta(questao, resposta)){
                quiz.pontos++;
            } else {
                System.out.println("Você errou. \n");
            }

        }
        System.out.println("Você acertou " + quiz.pontos + " de " + quiz.getQuestoes().size());
        quiz.pontos = 0;
    }

    private void registrarQuestão() {
        System.out.println("Digite sua pergunta: ");
        String pergunta = scanner.nextLine();
        System.out.println("Digite sua resposta: ");
        String resposta = scanner.nextLine();
        quiz.salvar(new Questao(pergunta, resposta));
    }
}
