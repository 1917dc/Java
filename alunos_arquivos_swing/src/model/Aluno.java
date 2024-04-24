package model;

import java.io.Serializable;

public record Aluno(String nome, String cpf, String curso) implements Serializable {
}
