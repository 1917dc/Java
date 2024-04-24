package controller;
import model.Aluno;
import model.DadosAluno;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO implements DadosAluno {
    @Override
    public void salvar(Aluno aluno) {
        Path path = Paths.get("alunos.bin");
        List<Aluno> alunos = new ArrayList<Aluno>();
        if(!Files.exists(path)){
            try {
                Files.createFile(path);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else{
            alunos = getAlunos();
        }
        alunos.add(aluno);

        try {
            var fos = Files.newOutputStream(path);
            var oos = new ObjectOutputStream(fos);
            for(Aluno alunoOutput : alunos){
                oos.writeObject(alunoOutput);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Aluno> getAlunos() {
        List<Aluno> alunos = new ArrayList<Aluno>();
        Path path = Paths.get("alunos.bin");
        if(Files.exists(path)){
            try {
                try(var fis = Files.newInputStream(path);
                    var ois = new ObjectInputStream(fis)){
                    while(fis.available() > 0){
                        Aluno aluno = (Aluno) ois.readObject();
                        alunos.add(aluno);
                    }
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }


            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return alunos;
    }
}
