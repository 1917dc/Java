package model;

import java.io.Serializable;

public class Aluno implements Serializable{
	private String nome;
	private String cpf;
	private String curso;
	
	public Aluno(String nome, String cpf, String curso) {
		setNome(nome);
		setCpf(cpf);
		setCurso(curso);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	@Override
	public String toString() {
		return "Aluno [nome=" + nome + ", cpf=" + cpf + ", curso=" + curso + "]";
	}
	
	
}
