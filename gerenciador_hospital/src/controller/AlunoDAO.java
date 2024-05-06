package controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import model.Aluno;
import model.InterfaceAluno;

public class AlunoDAO implements InterfaceAluno{

    @Override
    public void save(Aluno aluno){
        List<Aluno> alunos = new ArrayList<>();
        if(!Files.exists(getPath())){
            try {
                Files.createFile(getPath());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else alunos = fetchAll();
        for(Aluno alunoVerify : alunos) {
            if (alunoVerify.getCpf().equals(aluno.getCpf())) {
                throw new RuntimeException("Paciente" + alunoVerify.toString() + "já cadastrado, o paciente" + aluno.toString() + "não foi cadastrado.");
            }
        }
        alunos.add(aluno);
        writeFile(alunos);
	}

	@Override
	public void edit(Aluno aluno) {
		// TODO Auto-generated method stub
		var alunos = fetchAll();
        for(int i = 0; i < alunos.size(); i++){
            if(alunos.get(i).getCpf().equals(aluno.getCpf()))
                alunos.set(i, aluno);
        }
        writeFile(alunos);
	}

	@Override
	public void delete(Aluno aluno) {
		// TODO Auto-generated method stub
		var alunos = fetchAll();
        alunos.removeIf(alunoRemove -> alunoRemove.getCpf().equals(aluno.getCpf()));
        writeFile(alunos);
	}

	@Override
	public List<Aluno> fetchAll() {
		// TODO Auto-generated method stub
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
	private Path getPath(){
        return Paths.get("alunos.bin");
    }
    private void writeFile(List<Aluno> alunos){
        try(var fos = Files.newOutputStream(getPath());
            var oos = new ObjectOutputStream(fos)){
            for(Aluno alunoWrite : alunos)
                oos.writeObject(alunoWrite);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void readFile(List<Aluno> alunos){
        try(var fis = Files.newInputStream(getPath());
            var ois = new ObjectInputStream(fis)){
            while(fis.available() > 0){
                alunos.add((Aluno) ois.readObject());
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
	
}
