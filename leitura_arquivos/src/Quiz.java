import java.util.ArrayList;
import java.util.List;

public class Quiz implements DadosQuestao{
    Integer pontos;
    List questoes = new ArrayList<Questao>();
    DadosQuestoesArquivo dadosQuestoesArquivo = new DadosQuestoesArquivo();

    public Quiz(){
        this.pontos = 0;
        new ArrayList<Questao>();
        DadosQuestoesArquivo dadosQuestoesArquivo = new DadosQuestoesArquivo();
    }
    @Override
    public void salvar(Questao questao) {
           dadosQuestoesArquivo.salvar(questao);
    }
    @Override
    public List<Questao> getQuestoes() {
        List<Questao> questoes = dadosQuestoesArquivo.getQuestoes();
        return questoes;
    }
    public boolean verificarResposta(Questao questao, String resposta){
        return(questao.resposta().equals(resposta));
    }
}
