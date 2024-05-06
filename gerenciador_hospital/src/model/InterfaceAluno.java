package model;

import java.util.List;

public interface InterfaceAluno {
	void save(Aluno aluno);
	void edit(Aluno aluno);
	void delete(Aluno aluno);
	List<Aluno> fetchAll();
}
