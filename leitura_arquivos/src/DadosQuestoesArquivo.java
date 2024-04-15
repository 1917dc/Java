import java.util.ArrayList;
import java.util.List;
import java.nio.file.Path;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.StandardOpenOption;
import static java.nio.file.StandardOpenOption.APPEND;

public class DadosQuestoesArquivo implements DadosQuestao{
    @Override
    public void salvar(Questao questao) {
        Path filePath = Paths.get("dados.txt");
        List<Questao> questoes = new ArrayList<Questao>();
        if(!Files.exists(filePath)){
            try {
                Files.createFile(filePath);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            questoes = getQuestoes();
        }
        questoes.add(questao);
        try(var fos = Files.newOutputStream(filePath);
            var oos = new ObjectOutputStream(fos)) {
                for(Questao questaoOutput : questoes){
                    oos.writeObject(questaoOutput);
                }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<Questao> getQuestoes() {
        List<Questao> questoes = new ArrayList<Questao>();
        Path filePath = Paths.get("dados.txt");
        if(Files.exists(filePath)){
            try {
                try(var fis = Files.newInputStream(filePath);
                var ois = new ObjectInputStream(fis)){
                    while(fis.available() > 0){
                        try {
                            Questao questao = (Questao) ois.readObject();
                            questoes.add(questao);
                        } catch (IOException | ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return questoes;
    }
}
